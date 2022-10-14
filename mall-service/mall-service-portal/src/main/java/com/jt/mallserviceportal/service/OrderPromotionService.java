package com.jt.mallserviceportal.service;

import com.jt.domain.CartPromotionItem;
import com.jt.model.OrderCartItem;

import java.util.List;

/**
 * 促销管理Service
 */
public interface OrderPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OrderCartItem> cartItemList);
}
