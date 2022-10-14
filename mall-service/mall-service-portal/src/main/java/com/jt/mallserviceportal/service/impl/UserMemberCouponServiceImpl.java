package com.jt.mallserviceportal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jt.domain.AdCouponHistoryDetail;
import com.jt.domain.CartPromotionItem;
import com.jt.feign.*;
import com.jt.mallcommon.exception.Asserts;
import com.jt.mallserviceportal.service.UserMemberCouponService;
import com.jt.mallserviceportal.service.UserMemberService;
import com.jt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 会员优惠券管理Service实现类
 */
@Service
public class UserMemberCouponServiceImpl implements UserMemberCouponService {
    @Autowired
    private UserMemberService memberService;
    @Autowired
    private AdCouponFeign couponFeign;
    @Autowired
    private AdCouponHistoryFeign couponHistoryFeign;
    @Autowired
    private AdCouponProductRelationFeign couponProductRelationFeign;
    @Autowired
    private AdCouponProductCategoryRelationFeign couponProductCategoryRelationFeign;
    @Autowired
    private GoodsProductFeign goodsProductFeign;
    @Override
    public void add(Long couponId) {
        UserMember currentMember = memberService.getCurrentMember();
        //获取优惠券信息，判断数量
        AdCoupon coupon = couponFeign.selectByPrimaryKey(couponId);
        if(coupon==null){
            Asserts.fail("优惠券不存在");
        }
        if(coupon.getCount()<=0){
            Asserts.fail("优惠券已经领完了");
        }
        Date now = new Date();
        if(now.before(coupon.getEnableTime())){
            Asserts.fail("优惠券还没到领取时间");
        }
        //判断用户领取的优惠券数量是否超过限制
        AdCouponHistoryExample couponHistoryExample = new AdCouponHistoryExample();
        couponHistoryExample.createCriteria().andCouponIdEqualTo(couponId).andMemberIdEqualTo(currentMember.getId());
        long count = couponHistoryFeign.countByExample(couponHistoryExample);
        if(count>=coupon.getPerLimit()){
            Asserts.fail("您已经领取过该优惠券");
        }
        //生成领取优惠券历史
        AdCouponHistory couponHistory = new AdCouponHistory();
        couponHistory.setCouponId(couponId);
        couponHistory.setCouponCode(generateCouponCode(currentMember.getId()));
        couponHistory.setCreateTime(now);
        couponHistory.setMemberId(currentMember.getId());
        couponHistory.setMemberNickname(currentMember.getNickname());
        //主动领取
        couponHistory.setGetType(1);
        //未使用
        couponHistory.setUseStatus(0);
        couponHistoryFeign.insert(couponHistory);
        //修改优惠券表的数量、领取数量
        coupon.setCount(coupon.getCount()-1);
        coupon.setReceiveCount(coupon.getReceiveCount()==null?1:coupon.getReceiveCount()+1);
        couponFeign.updateByPrimaryKey(coupon);
    }

    /**
     * 16位优惠码生成：时间戳后8位+4位随机数+用户id后4位
     */
    private String generateCouponCode(Long memberId) {
        StringBuilder sb = new StringBuilder();
        Long currentTimeMillis = System.currentTimeMillis();
        String timeMillisStr = currentTimeMillis.toString();
        sb.append(timeMillisStr.substring(timeMillisStr.length() - 8));
        for (int i = 0; i < 4; i++) {
            sb.append(new Random().nextInt(10));
        }
        String memberIdStr = memberId.toString();
        if (memberIdStr.length() <= 4) {
            sb.append(String.format("%04d", memberId));
        } else {
            sb.append(memberIdStr.substring(memberIdStr.length()-4));
        }
        return sb.toString();
    }

    @Override
    public List<AdCouponHistory> listHistory(Integer useStatus) {
        UserMember currentMember = memberService.getCurrentMember();
        AdCouponHistoryExample couponHistoryExample=new AdCouponHistoryExample();
        AdCouponHistoryExample.Criteria criteria = couponHistoryExample.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        if(useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        return couponHistoryFeign.selectByExample(couponHistoryExample);
    }

    @Override
    public List<AdCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type) {
        UserMember currentMember = memberService.getCurrentMember();
        Date now = new Date();
        //获取该用户所有优惠券
        List<AdCouponHistoryDetail> allList = couponHistoryFeign.getDetailList(currentMember.getId());
        //根据优惠券使用类型来判断优惠券是否可用
        List<AdCouponHistoryDetail> enableList = new ArrayList<>();
        List<AdCouponHistoryDetail> disableList = new ArrayList<>();
        for (AdCouponHistoryDetail couponHistoryDetail : allList) {
            Integer useType = couponHistoryDetail.getCoupon().getUseType();
            BigDecimal minPoint = couponHistoryDetail.getCoupon().getMinPoint();
            Date endTime = couponHistoryDetail.getCoupon().getEndTime();
            if(useType.equals(0)){
                //0->全场通用
                //判断是否满足优惠起点
                //计算购物车商品的总价
                BigDecimal totalAmount = calcTotalAmount(cartItemList);
                if(now.before(endTime)&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }else if(useType.equals(1)){
                //1->指定分类
                //计算指定分类商品的总价
                List<Long> productCategoryIds = new ArrayList<>();
                for (AdCouponProductCategoryRelation categoryRelation : couponHistoryDetail.getCategoryRelationList()) {
                    productCategoryIds.add(categoryRelation.getProductCategoryId());
                }
                BigDecimal totalAmount = calcTotalAmountByproductCategoryId(cartItemList,productCategoryIds);
                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }else if(useType.equals(2)){
                //2->指定商品
                //计算指定商品的总价
                List<Long> productIds = new ArrayList<>();
                for (AdCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                    productIds.add(productRelation.getProductId());
                }
                BigDecimal totalAmount = calcTotalAmountByProductId(cartItemList,productIds);
                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }
        }
        if(type.equals(1)){
            return enableList;
        }else{
            return disableList;
        }
    }

    @Override
    public List<AdCoupon> listByProduct(Long productId) {
        List<Long> allCouponIds = new ArrayList<>();
        //获取指定商品优惠券
        AdCouponProductRelationExample cprExample = new AdCouponProductRelationExample();
        cprExample.createCriteria().andProductIdEqualTo(productId);
        List<AdCouponProductRelation> cprList = couponProductRelationFeign.selectByExample(cprExample);
        if(CollUtil.isNotEmpty(cprList)){
            List<Long> couponIds = cprList.stream().map(AdCouponProductRelation::getCouponId).collect(Collectors.toList());
            allCouponIds.addAll(couponIds);
        }
        //获取指定分类优惠券
        GoodsProduct product = goodsProductFeign.selectByPrimaryKey(productId);
        AdCouponProductCategoryRelationExample cpcrExample = new AdCouponProductCategoryRelationExample();
        cpcrExample.createCriteria().andProductCategoryIdEqualTo(product.getProductCategoryId());
        List<AdCouponProductCategoryRelation> cpcrList = couponProductCategoryRelationFeign.selectByExample(cpcrExample);
        if(CollUtil.isNotEmpty(cpcrList)){
            List<Long> couponIds = cpcrList.stream().map(AdCouponProductCategoryRelation::getCouponId).collect(Collectors.toList());
            allCouponIds.addAll(couponIds);
        }
        if(CollUtil.isEmpty(allCouponIds)){
            return new ArrayList<>();
        }
        //所有优惠券
        AdCouponExample couponExample = new AdCouponExample();
        couponExample.createCriteria().andEndTimeGreaterThan(new Date())
                .andStartTimeLessThan(new Date())
                .andUseTypeEqualTo(0);
        couponExample.or(couponExample.createCriteria()
                .andEndTimeGreaterThan(new Date())
                .andStartTimeLessThan(new Date())
                .andUseTypeNotEqualTo(0)
                .andIdIn(allCouponIds));
        return couponFeign.selectByExample(couponExample);
    }

    @Override
    public List<AdCoupon> list(Integer useStatus) {
        UserMember member = memberService.getCurrentMember();
        return couponHistoryFeign.getCouponList(member.getId(),useStatus);
    }

    private BigDecimal calcTotalAmount(List<CartPromotionItem> cartItemList) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
            total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
        }
        return total;
    }

    private BigDecimal calcTotalAmountByproductCategoryId(List<CartPromotionItem> cartItemList,List<Long> productCategoryIds) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            if(productCategoryIds.contains(item.getProductCategoryId())){
                BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
            }
        }
        return total;
    }

    private BigDecimal calcTotalAmountByProductId(List<CartPromotionItem> cartItemList,List<Long> productIds) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            if(productIds.contains(item.getProductId())){
                BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
            }
        }
        return total;
    }

}
