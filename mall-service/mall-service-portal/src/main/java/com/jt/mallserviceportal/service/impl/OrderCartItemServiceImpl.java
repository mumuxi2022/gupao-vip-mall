package com.jt.mallserviceportal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jt.domain.CartPromotionItem;
import com.jt.feign.AdCouponFeign;
import com.jt.feign.OrderCartItemFeign;
import com.jt.feign.PortalProductFeign;
import com.jt.mallserviceportal.service.OrderCartItemService;
import com.jt.mallserviceportal.service.OrderPromotionService;
import com.jt.mallserviceportal.service.UserMemberService;
import com.jt.model.CartProduct;
import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;
import com.jt.model.UserMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 购物车管理Service实现类
 */
@Service
public class OrderCartItemServiceImpl implements OrderCartItemService {
    @Autowired
    private OrderCartItemFeign cartItemFeign;
    @Autowired
    private PortalProductFeign portalProductFeign;
    @Autowired
    private OrderPromotionService promotionService;
    @Autowired
    private UserMemberService memberService;

    @Override
    public int add(OrderCartItem cartItem) {
        int count;
        UserMember currentMember =memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OrderCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null) {
            cartItem.setCreateDate(new Date());
            count = cartItemFeign.insert(cartItem);
        } else {
            cartItem.setModifyDate(new Date());
            existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
            count = cartItemFeign.updateByPrimaryKey(existCartItem);
        }
        return count;
    }

    /**
     * 根据会员id,商品id和规格获取购物车中商品
     */
    private OrderCartItem getCartItem(OrderCartItem cartItem) {
        OrderCartItemExample example = new OrderCartItemExample();
        OrderCartItemExample.Criteria criteria = example.createCriteria().andMemberIdEqualTo(cartItem.getMemberId())
                .andProductIdEqualTo(cartItem.getProductId()).andDeleteStatusEqualTo(0);
        if (!StringUtils.isEmpty(cartItem.getProductSkuId())) {
            criteria.andProductSkuIdEqualTo(cartItem.getProductSkuId());
        }
        List<OrderCartItem> cartItemList = cartItemFeign.selectByExample(example);
        if (!CollectionUtils.isEmpty(cartItemList)) {
            return cartItemList.get(0);
        }
        return null;
    }

    @Override
    public List<OrderCartItem> list(Long memberId) {
        OrderCartItemExample example = new OrderCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(memberId);
        return cartItemFeign.selectByExample(example);
    }

    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds) {
        List<OrderCartItem> cartItemList = list(memberId);
        if(CollUtil.isNotEmpty(cartIds)){
            cartItemList = cartItemList.stream().filter(item->cartIds.contains(item.getId())).collect(Collectors.toList());
        }
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cartItemList)){
            cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
        }
        return cartPromotionItemList;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        OrderCartItem cartItem = new OrderCartItem();
        cartItem.setQuantity(quantity);
        OrderCartItemExample example = new OrderCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andIdEqualTo(id).andMemberIdEqualTo(memberId);
        Map<String,Object> map = new HashMap();
        map.put("OrderCartItem",cartItem);
        map.put("OrderCartItemExample",example);
        return cartItemFeign.updateByExampleSelective(map);
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        OrderCartItem record = new OrderCartItem();
        record.setDeleteStatus(1);
        OrderCartItemExample example = new OrderCartItemExample();
        example.createCriteria().andIdIn(ids).andMemberIdEqualTo(memberId);
        Map<String,Object> map = new HashMap();
        map.put("OrderCartItem",record);
        map.put("OrderCartItemExample",example);
        return cartItemFeign.updateByExampleSelective(map);
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return portalProductFeign.getCartProduct(productId);
    }

    @Override
    public int updateAttr(OrderCartItem cartItem) {
        //删除原购物车信息
        OrderCartItem updateCart = new OrderCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(new Date());
        updateCart.setDeleteStatus(1);
        cartItemFeign.updateByPrimaryKeySelective(updateCart);
        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public int clear(Long memberId) {
        OrderCartItem record = new OrderCartItem();
        record.setDeleteStatus(1);
        OrderCartItemExample example = new OrderCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        Map<String,Object> map = new HashMap();
        map.put("OrderCartItem",record);
        map.put("OrderCartItemExample",example);
        return cartItemFeign.updateByExampleSelective(map);
    }
}
