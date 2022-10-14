package com.jt.dto;

import com.jt.model.AdFlashPromotionProductRelation;
import com.jt.model.GoodsProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 */
public class AdFlashPromotionProduct extends AdFlashPromotionProductRelation {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private GoodsProduct product;
}
