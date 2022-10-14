package com.jt.domain;

import com.jt.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 前台商品详情
 */
@Getter
@Setter
public class GoodsPortalProductDetail {
    @ApiModelProperty("商品信息")
    private GoodsProduct product;
    @ApiModelProperty("商品品牌")
    private GoodsBrand brand;
    @ApiModelProperty("商品属性与参数")
    private List<GoodsProductAttribute> productAttributeList;
    @ApiModelProperty("手动录入的商品属性与参数值")
    private List<GoodsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("商品的sku库存信息")
    private List<GoodsSkuStock> skuStockList;
    @ApiModelProperty("商品阶梯价格设置")
    private List<GoodsProductLadder> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<GoodsProductFullReduction> productFullReductionList;
    @ApiModelProperty("商品可用优惠券")
    private List<AdCoupon> couponList;
}
