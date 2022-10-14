package com.jt.mallservicegoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.GoodsProductAttributeCategoryItem;
import com.jt.mallservicegoods.mapper.GoodsProductAttributeCategoryMapper;
import com.jt.mallservicegoods.service.GoodsProductAttributeCategoryService;
import com.jt.model.GoodsProductAttributeCategory;
import com.jt.model.GoodsProductAttributeCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GoodsProductAttributeCategoryService实现类
 */
@Service
public class GoodsProductAttributeCategoryServiceImpl implements GoodsProductAttributeCategoryService {
    @Autowired
    private GoodsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public int create(String name) {
        GoodsProductAttributeCategory productAttributeCategory = new GoodsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    @Override
    public int update(Long id, String name) {
        GoodsProductAttributeCategory productAttributeCategory = new GoodsProductAttributeCategory();
        productAttributeCategory.setName(name);
        productAttributeCategory.setId(id);
        return productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
    }

    @Override
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GoodsProductAttributeCategory getItem(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GoodsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return productAttributeCategoryMapper.selectByExample(new GoodsProductAttributeCategoryExample());
    }

    @Override
    public List<GoodsProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryMapper.getListWithAttr();
    }
}
