package com.jt.mallservicegoods.service;


import com.jt.domain.HomeContentResult;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductCategory;

import java.util.List;

/**
 * 首页内容管理Service
 */
public interface GoodsHomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<GoodsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<GoodsProductCategory> getProductCateList(Long parentId);

    /**
     * 分页获取人气推荐商品
     */
    List<GoodsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     */
    List<GoodsProduct> newProductList(Integer pageNum, Integer pageSize);
}
