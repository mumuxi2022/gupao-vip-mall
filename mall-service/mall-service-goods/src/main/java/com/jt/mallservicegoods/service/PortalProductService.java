package com.jt.mallservicegoods.service;


import com.jt.model.CartProduct;
import com.jt.model.GoodsSkuStock;
import com.jt.model.OrderItem;
import com.jt.model.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Service
 */
public interface PortalProductService {
    CartProduct getCartProduct(Long id);
    List<PromotionProduct> getPromotionProductList(List<Long> ids);
    int updateSkuStock(List<OrderItem> orderItemList);
    int releaseSkuStockLock(List<OrderItem> orderItemList);
}
