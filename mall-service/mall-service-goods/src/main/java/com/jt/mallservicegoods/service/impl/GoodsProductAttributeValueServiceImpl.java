package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.GoodsProductAttributeValueMapper;
import com.jt.mallservicegoods.service.GoodsProductAttributeValueService;
import com.jt.model.GoodsProductAttributeValue;
import com.jt.model.GoodsProductAttributeValueExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsProductAttributeValueServiceImpl implements GoodsProductAttributeValueService {
    @Autowired
    private GoodsProductAttributeValueMapper productAttributeValueMapper;

    @Override
    public long countByExample(GoodsProductAttributeValueExample example) {
        return productAttributeValueMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductAttributeValueExample example) {
        return productAttributeValueMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productAttributeValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProductAttributeValue record) {
        return productAttributeValueMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProductAttributeValue record) {
        return productAttributeValueMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProductAttributeValue> selectByExample(GoodsProductAttributeValueExample example) {
        return productAttributeValueMapper.selectByExample(example);
    }

    @Override
    public GoodsProductAttributeValue selectByPrimaryKey(Long id) {
        return productAttributeValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProductAttributeValue record, GoodsProductAttributeValueExample example) {
        return productAttributeValueMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsProductAttributeValue record, GoodsProductAttributeValueExample example) {
        return productAttributeValueMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProductAttributeValue record) {
        return productAttributeValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProductAttributeValue record) {
        return productAttributeValueMapper.updateByPrimaryKey(record);
    }

}
