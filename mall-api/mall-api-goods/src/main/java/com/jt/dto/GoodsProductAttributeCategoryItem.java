package com.jt.dto;

import com.jt.model.GoodsProductAttribute;
import com.jt.model.GoodsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 */
public class GoodsProductAttributeCategoryItem extends GoodsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<GoodsProductAttribute> productAttributeList;
}
