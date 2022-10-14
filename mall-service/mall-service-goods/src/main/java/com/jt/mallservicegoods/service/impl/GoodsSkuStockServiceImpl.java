package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.GoodsSkuStockMapper;
import com.jt.mallservicegoods.service.GoodsSkuStockService;
import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStockExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品sku库存管理Service实现类
 */
@Service
public class GoodsSkuStockServiceImpl implements GoodsSkuStockService {
    @Autowired
    private GoodsSkuStockMapper skuStockMapper;

    @Override
    public List<GoodsSkuStock> getList(Long pid, String keyword) {
        GoodsSkuStockExample example = new GoodsSkuStockExample();
        GoodsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<GoodsSkuStock> skuStockList) {
        return skuStockMapper.replaceList(skuStockList);
    }

    @Override
    public long countByExample(GoodsSkuStockExample example) {
        return skuStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsSkuStockExample example) {
        return skuStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuStockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsSkuStock record) {
        return skuStockMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsSkuStock record) {
        return skuStockMapper.insertSelective(record);
    }

    @Override
    public List<GoodsSkuStock> selectByExample(GoodsSkuStockExample example) {
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public GoodsSkuStock selectByPrimaryKey(Long id) {
        return skuStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsSkuStock record, GoodsSkuStockExample example) {
        return skuStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsSkuStock record, GoodsSkuStockExample example) {
        return skuStockMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSkuStock record) {
        return skuStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsSkuStock record) {
        return skuStockMapper.updateByPrimaryKey(record);
    }
}
