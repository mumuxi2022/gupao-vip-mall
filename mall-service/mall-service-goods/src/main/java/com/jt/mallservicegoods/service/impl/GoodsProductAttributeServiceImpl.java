package com.jt.mallservicegoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.GoodsProductAttributeParam;
import com.jt.dto.ProductAttrInfo;
import com.jt.mallservicegoods.mapper.GoodsProductAttributeCategoryMapper;
import com.jt.mallservicegoods.mapper.GoodsProductAttributeMapper;
import com.jt.mallservicegoods.service.GoodsProductAttributeService;
import com.jt.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性Service实现类
 */
@Service
public class GoodsProductAttributeServiceImpl implements GoodsProductAttributeService {
    @Autowired
    private GoodsProductAttributeMapper productAttributeMapper;
    @Autowired
    private GoodsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public List<GoodsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsProductAttributeExample example = new GoodsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(example);
    }

    @Override
    public int create(GoodsProductAttributeParam goodsProductAttributeParam) {
        GoodsProductAttribute goodsProductAttribute = new GoodsProductAttribute();
        BeanUtils.copyProperties(goodsProductAttributeParam, goodsProductAttribute);
        int count = productAttributeMapper.insertSelective(goodsProductAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        GoodsProductAttributeCategory goodsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(goodsProductAttribute.getProductAttributeCategoryId());
        if(goodsProductAttribute.getType()==0){
            goodsProductAttributeCategory.setAttributeCount(goodsProductAttributeCategory.getAttributeCount()+1);
        }else if(goodsProductAttribute.getType()==1){
            goodsProductAttributeCategory.setParamCount(goodsProductAttributeCategory.getParamCount()+1);
        }
        productAttributeCategoryMapper.updateByPrimaryKey(goodsProductAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id, GoodsProductAttributeParam productAttributeParam) {
        GoodsProductAttribute goodsProductAttribute = new GoodsProductAttribute();
        goodsProductAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam, goodsProductAttribute);
        return productAttributeMapper.updateByPrimaryKeySelective(goodsProductAttribute);
    }

    @Override
    public GoodsProductAttribute getItem(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        GoodsProductAttribute goodsProductAttribute = productAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = goodsProductAttribute.getType();
        GoodsProductAttributeCategory goodsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(goodsProductAttribute.getProductAttributeCategoryId());
        GoodsProductAttributeExample example = new GoodsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = productAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if(type==0){
            if(goodsProductAttributeCategory.getAttributeCount()>=count){
                goodsProductAttributeCategory.setAttributeCount(goodsProductAttributeCategory.getAttributeCount()-count);
            }else{
                goodsProductAttributeCategory.setAttributeCount(0);
            }
        }else if(type==1){
            if(goodsProductAttributeCategory.getParamCount()>=count){
                goodsProductAttributeCategory.setParamCount(goodsProductAttributeCategory.getParamCount()-count);
            }else{
                goodsProductAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(goodsProductAttributeCategory);
        return count;
    }

    @Override
    public List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return productAttributeMapper.getProductAttrInfo(productCategoryId);
    }

    @Override
    public long countByExample(GoodsProductAttributeExample example) {
        return productAttributeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductAttributeExample example) {
        return productAttributeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productAttributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProductAttribute record) {
        return productAttributeMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProductAttribute record) {
        return productAttributeMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProductAttribute> selectByExample(GoodsProductAttributeExample example) {
        return productAttributeMapper.selectByExample(example);
    }

    @Override
    public GoodsProductAttribute selectByPrimaryKey(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProductAttribute record, GoodsProductAttributeExample example) {
        return productAttributeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsProductAttribute record, GoodsProductAttributeExample example) {
        return productAttributeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProductAttribute record) {
        return productAttributeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProductAttribute record) {
        return productAttributeMapper.updateByPrimaryKey(record);
    }

}
