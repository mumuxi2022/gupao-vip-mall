package com.jt.mallservicegoods.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicegoods.service.GoodsSkuStockService;
import com.jt.mallservicegoods.service.PortalProductService;
import com.jt.model.CartProduct;
import com.jt.model.GoodsSkuStock;
import com.jt.model.OrderItem;
import com.jt.model.PromotionProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台系统自定义商品Controller
 */
@Controller
@Api(tags = "PortalProductController", description = "前台系统自定义商品管理")
@RequestMapping("/portalProduct")
public class PortalProductController {
    @Autowired
    private PortalProductService portalProductService;

    @ApiOperation("根据id获取商品")
    @RequestMapping(value = "/getCartProduct", method = RequestMethod.GET)
    @ResponseBody
    public CartProduct getCartProduct(@RequestParam("id") Long id) {
        return portalProductService.getCartProduct(id);
    }

    @ApiOperation("根据ids获取商品")
    @RequestMapping(value = "/getPromotionProductList", method = RequestMethod.GET)
    @ResponseBody
    public List<PromotionProduct> getPromotionProductList(@RequestParam("ids") List<Long> ids) {
        return portalProductService.getPromotionProductList(ids);
    }

    /**
     * 修改 goods_sku_stock表的锁定库存及真实库存
     */
    @ApiOperation(value = "更新SKU")
    @RequestMapping(value = "/updateSkuStock", method = RequestMethod.PUT)
    @ResponseBody
    public int updateSkuStock(@RequestParam("itemList") List<OrderItem> orderItemList){
        return portalProductService.updateSkuStock(orderItemList);
    }

    /**
     * 解除取消订单的库存锁定
     */
    @ApiOperation(value = "批量修改订单状态")
    @RequestMapping(value = "/releaseSkuStockLock", method = RequestMethod.PUT)
    @ResponseBody
    public int releaseSkuStockLock(@RequestParam("itemList") List<OrderItem> orderItemList){
        return portalProductService.releaseSkuStockLock(orderItemList);
    }

}
