package com.jt.mallservicegoods.service;


import com.jt.model.GoodsProductFullReduction;
import com.jt.model.GoodsProductFullReductionExample;

import java.util.List;

public interface GoodsProductFullReductionService {

    long countByExample(GoodsProductFullReductionExample example);

    int deleteByExample(GoodsProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductFullReduction record);

    int insertSelective(GoodsProductFullReduction record);

    List<GoodsProductFullReduction> selectByExample(GoodsProductFullReductionExample example);

    GoodsProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProductFullReduction record, GoodsProductFullReductionExample example);

    int updateByExample(GoodsProductFullReduction record,GoodsProductFullReductionExample example);

    int updateByPrimaryKeySelective(GoodsProductFullReduction record);

    int updateByPrimaryKey(GoodsProductFullReduction record);
}
