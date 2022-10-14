package com.jt.dto;

import com.jt.model.AdCoupon;
import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 */
public class AdCouponParam extends AdCoupon {
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<AdCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<AdCouponProductCategoryRelation> productCategoryRelationList;
}
