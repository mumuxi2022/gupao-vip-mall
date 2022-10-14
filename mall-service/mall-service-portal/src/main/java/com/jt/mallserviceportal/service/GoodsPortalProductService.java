package com.jt.mallserviceportal.service;


import com.jt.domain.GoodsPortalProductDetail;
import com.jt.domain.GoodsProductCategoryNode;
import com.jt.model.GoodsProduct;

import java.util.List;

/**
 * 前台商品管理Service
 */
public interface GoodsPortalProductService {
    /**
     * 综合搜索商品
     */
    List<GoodsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<GoodsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    GoodsPortalProductDetail detail(Long id);
}
