package com.jt.mallservicegoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.GoodsProductCategoryParam;
import com.jt.dto.GoodsProductCategoryWithChildrenItem;
import com.jt.mallservicegoods.mapper.GoodsProductCategoryAttributeRelationMapper;
import com.jt.mallservicegoods.mapper.GoodsProductCategoryMapper;
import com.jt.mallservicegoods.mapper.GoodsProductMapper;
import com.jt.mallservicegoods.service.GoodsProductCategoryService;
import com.jt.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * GoodsProductCategoryService实现类
 */
@Service
public class GoodsProductCategoryServiceImpl implements GoodsProductCategoryService {
    @Autowired
    private GoodsProductCategoryMapper productCategoryMapper;
    @Autowired
    private GoodsProductMapper productMapper;
    @Autowired
    private GoodsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;
    @Override
    public int create(GoodsProductCategoryParam goodsProductCategoryParam) {
        GoodsProductCategory productCategory = new GoodsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(goodsProductCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = productCategoryMapper.insertSelective(productCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = goodsProductCategoryParam.getProductAttributeIdList();
        if(!CollectionUtils.isEmpty(productAttributeIdList)){
            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

    /**
     * 批量插入商品分类与筛选属性关系表
     * @param productCategoryId 商品分类id
     * @param productAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<GoodsProductCategoryAttributeRelation> relationList = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            GoodsProductCategoryAttributeRelation relation = new GoodsProductCategoryAttributeRelation();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        productCategoryAttributeRelationMapper.insertList(relationList);
    }

    @Override
    public int update(Long id, GoodsProductCategoryParam goodsProductCategoryParam) {
        GoodsProductCategory productCategory = new GoodsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(goodsProductCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        GoodsProduct product = new GoodsProduct();
        product.setProductCategoryName(productCategory.getName());
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andProductCategoryIdEqualTo(id);
        productMapper.updateByExampleSelective(product,example);
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(goodsProductCategoryParam.getProductAttributeIdList())){
            GoodsProductCategoryAttributeRelationExample relationExample = new GoodsProductCategoryAttributeRelationExample();
            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
            insertRelationList(id,goodsProductCategoryParam.getProductAttributeIdList());
        }else{
            GoodsProductCategoryAttributeRelationExample relationExample = new GoodsProductCategoryAttributeRelationExample();
            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
        }
        return productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public List<GoodsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsProductCategoryExample example = new GoodsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GoodsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        GoodsProductCategory productCategory = new GoodsProductCategory();
        productCategory.setNavStatus(navStatus);
        GoodsProductCategoryExample example = new GoodsProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        GoodsProductCategory productCategory = new GoodsProductCategory();
        productCategory.setShowStatus(showStatus);
        GoodsProductCategoryExample example = new GoodsProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public List<GoodsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryMapper.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(GoodsProductCategory productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            GoodsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }

    @Override
    public List<GoodsProductCategory> listByExample(GoodsProductCategoryExample goodsProductCategoryExample){
        return productCategoryMapper.selectByExample(goodsProductCategoryExample);
    }

    @Override
    public long countByExample(GoodsProductCategoryExample example) {
        return productCategoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductCategoryExample example) {
        return productCategoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProductCategory record) {
        return productCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProductCategory record) {
        return productCategoryMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProductCategory> selectByExample(GoodsProductCategoryExample example) {
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public GoodsProductCategory selectByPrimaryKey(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProductCategory record, GoodsProductCategoryExample example) {
        return productCategoryMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsProductCategory record, GoodsProductCategoryExample example) {
        return productCategoryMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProductCategory record) {
        return productCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProductCategory record) {
        return productCategoryMapper.updateByPrimaryKey(record);
    }

}
