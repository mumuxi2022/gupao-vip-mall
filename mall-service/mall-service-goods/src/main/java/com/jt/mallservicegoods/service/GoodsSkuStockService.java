package com.jt.mallservicegoods.service;


import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStockExample;

import java.util.List;

/**
 * sku商品库存管理Service
 */
public interface GoodsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<GoodsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<GoodsSkuStock> skuStockList);

    long countByExample(GoodsSkuStockExample example);

    int deleteByExample(GoodsSkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSkuStock record);

    int insertSelective(GoodsSkuStock record);

    List<GoodsSkuStock> selectByExample(GoodsSkuStockExample example);

    GoodsSkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsSkuStock record, GoodsSkuStockExample example);

    int updateByExample(GoodsSkuStock record,GoodsSkuStockExample example);

    int updateByPrimaryKeySelective(GoodsSkuStock record);

    int updateByPrimaryKey(GoodsSkuStock record);
}
