package com.jt.mallservicegoods.service;


import com.jt.dto.GoodsProductAttributeCategoryItem;
import com.jt.model.GoodsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类Service
 */
public interface GoodsProductAttributeCategoryService {
    /**
     * 创建属性分类
     */
    int create(String name);

    /**
     * 修改属性分类
     */
    int update(Long id, String name);

    /**
     * 删除属性分类
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     */
    GoodsProductAttributeCategory getItem(Long id);

    /**
     * 分页查询属性分类
     */
    List<GoodsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取包含属性的属性分类
     */
    List<GoodsProductAttributeCategoryItem> getListWithAttr();
}
