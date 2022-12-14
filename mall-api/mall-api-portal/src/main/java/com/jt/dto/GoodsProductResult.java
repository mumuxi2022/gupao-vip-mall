package com.jt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询单个产品进行修改时返回的结果
 */
public class GoodsProductResult extends GoodsProductParam {
    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
