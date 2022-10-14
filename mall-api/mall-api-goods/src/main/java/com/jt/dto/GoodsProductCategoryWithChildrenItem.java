package com.jt.dto;

import com.jt.model.GoodsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class GoodsProductCategoryWithChildrenItem extends GoodsProductCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<GoodsProductCategory> children;
}
