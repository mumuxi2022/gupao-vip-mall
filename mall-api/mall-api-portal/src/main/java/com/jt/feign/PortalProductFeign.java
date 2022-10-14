package com.jt.feign;

import com.jt.model.AdCoupon;
import com.jt.model.CartProduct;
import com.jt.model.OrderItem;
import com.jt.model.PromotionProduct;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface PortalProductFeign {

    @GetMapping(value = "/portalProduct/getCartProduct")
    CartProduct getCartProduct(@RequestParam("id") Long id);

    @GetMapping(value = "/portalProduct/getPromotionProductList")
    List<PromotionProduct> getPromotionProductList(@RequestParam("ids") List<Long> ids);

    /**
     * 修改 goods_sku_stock表的锁定库存及真实库存
     */
    @PutMapping(value = "/portalProduct/updateSkuStock")
    int updateSkuStock(@RequestParam("itemList") List<OrderItem> orderItemList);

    /**
     * 解除取消订单的库存锁定
     */
    @PutMapping(value = "/portalProduct/releaseSkuStockLock")
    int releaseSkuStockLock(@RequestParam("itemList") List<OrderItem> orderItemList);

}
