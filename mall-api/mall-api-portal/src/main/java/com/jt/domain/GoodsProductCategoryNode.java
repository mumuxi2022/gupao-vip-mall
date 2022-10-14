package com.jt.domain;

import com.jt.model.GoodsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含子分类的商品分类
 */
@Getter
@Setter
public class GoodsProductCategoryNode extends GoodsProductCategory {
    @ApiModelProperty("子分类集合")
    private List<GoodsProductCategoryNode> children;
}
