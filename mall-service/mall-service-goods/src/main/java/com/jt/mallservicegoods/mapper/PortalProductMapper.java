package com.jt.mallservicegoods.mapper;

import com.jt.model.CartProduct;
import com.jt.model.OrderItem;
import com.jt.model.PromotionProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 */
@Repository
public interface PortalProductMapper {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
    /**
     * 修改 goods_sku_stock表的锁定库存及真实库存
     */
    int updateSkuStock(@Param("itemList") List<OrderItem> orderItemList);

    /**
     * 解除取消订单的库存锁定
     */
    int releaseSkuStockLock(@Param("itemList") List<OrderItem> orderItemList);
}
