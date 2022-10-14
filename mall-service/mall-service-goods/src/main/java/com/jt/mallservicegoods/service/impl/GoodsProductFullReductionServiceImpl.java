package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.GoodsProductFullReductionMapper;
import com.jt.mallservicegoods.service.GoodsProductFullReductionService;
import com.jt.model.GoodsProductFullReduction;
import com.jt.model.GoodsProductFullReductionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsProductFullReductionServiceImpl implements GoodsProductFullReductionService {
    @Autowired
    private GoodsProductFullReductionMapper skuStockMapper;


    @Override
    public long countByExample(GoodsProductFullReductionExample example) {
        return skuStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductFullReductionExample example) {
        return skuStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuStockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProductFullReduction record) {
        return skuStockMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProductFullReduction record) {
        return skuStockMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProductFullReduction> selectByExample(GoodsProductFullReductionExample example) {
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public GoodsProductFullReduction selectByPrimaryKey(Long id) {
        return skuStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProductFullReduction record, GoodsProductFullReductionExample example) {
        return skuStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsProductFullReduction record, GoodsProductFullReductionExample example) {
        return skuStockMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProductFullReduction record) {
        return skuStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProductFullReduction record) {
        return skuStockMapper.updateByPrimaryKey(record);
    }
}
