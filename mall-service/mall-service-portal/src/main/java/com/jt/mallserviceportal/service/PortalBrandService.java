package com.jt.mallserviceportal.service;

import com.jt.mallcommon.api.CommonPage;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsProduct;

import java.util.List;

/**
 * 前台品牌管理Service
 */
public interface PortalBrandService {
    /**
     * 分页获取推荐品牌
     */
    List<GoodsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     */
    GoodsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<GoodsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
