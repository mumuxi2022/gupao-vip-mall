package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStockExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsSkuStockMapper {
    long countByExample(GoodsSkuStockExample example);

    int deleteByExample(GoodsSkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSkuStock record);

    int insertSelective(GoodsSkuStock record);

    List<GoodsSkuStock> selectByExample(GoodsSkuStockExample example);

    GoodsSkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSkuStock record, @Param("example") GoodsSkuStockExample example);

    int updateByExample(@Param("record") GoodsSkuStock record, @Param("example") GoodsSkuStockExample example);

    int updateByPrimaryKeySelective(GoodsSkuStock record);

    int updateByPrimaryKey(GoodsSkuStock record);

    /**
     * 批量插入操作
     */
    int insertList(List<GoodsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(List<GoodsSkuStock> skuStockList);
}