package com.jt.mallserviceportal.service;

import com.jt.domain.AdCouponHistoryDetail;
import com.jt.domain.CartPromotionItem;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理Service
 */
public interface UserMemberCouponService {
    /**
     * 会员添加优惠券
     */
    @Transactional
    void add(Long couponId);

    /**
     * 获取优惠券历史列表
     */
    List<AdCouponHistory> listHistory(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     */
    List<AdCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);

    /**
     * 获取当前商品相关优惠券
     */
    List<AdCoupon> listByProduct(Long productId);

    /**
     * 获取用户优惠券列表
     */
    List<AdCoupon> list(Integer useStatus);
}
