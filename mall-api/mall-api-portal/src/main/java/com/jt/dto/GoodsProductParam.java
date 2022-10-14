package com.jt.dto;

import com.jt.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 创建和修改商品时使用的参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsProductParam extends GoodsProduct {
    @ApiModelProperty("商品阶梯价格设置")
    private List<GoodsProductLadder> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<GoodsProductFullReduction> productFullReductionList;
    @ApiModelProperty("商品会员价格设置")
    private List<GoodsMemberPrice> memberPriceList;
    @ApiModelProperty("商品的sku库存信息")
    private List<GoodsSkuStock> skuStockList;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<GoodsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("专题和商品关系")
    private List<ContextSubjectProductRelation> subjectProductRelationList;
    @ApiModelProperty("优选专区和商品的关系")
    private List<ContextPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
