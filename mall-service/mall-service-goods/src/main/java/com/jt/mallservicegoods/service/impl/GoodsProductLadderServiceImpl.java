package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.GoodsProductLadderMapper;
import com.jt.mallservicegoods.service.GoodsProductLadderService;
import com.jt.model.GoodsProductLadder;
import com.jt.model.GoodsProductLadderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsProductLadderServiceImpl implements GoodsProductLadderService {
    @Autowired
    private GoodsProductLadderMapper skuStockMapper;


    @Override
    public long countByExample(GoodsProductLadderExample example) {
        return skuStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductLadderExample example) {
        return skuStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuStockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProductLadder record) {
        return skuStockMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProductLadder record) {
        return skuStockMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProductLadder> selectByExample(GoodsProductLadderExample example) {
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public GoodsProductLadder selectByPrimaryKey(Long id) {
        return skuStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProductLadder record, GoodsProductLadderExample example) {
        return skuStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsProductLadder record, GoodsProductLadderExample example) {
        return skuStockMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProductLadder record) {
        return skuStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProductLadder record) {
        return skuStockMapper.updateByPrimaryKey(record);
    }
}
