package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductFullReduction;
import com.jt.model.GoodsProductFullReductionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductFullReductionMapper {
    long countByExample(GoodsProductFullReductionExample example);

    int deleteByExample(GoodsProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductFullReduction record);

    int insertSelective(GoodsProductFullReduction record);

    List<GoodsProductFullReduction> selectByExample(GoodsProductFullReductionExample example);

    GoodsProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductFullReduction record, @Param("example") GoodsProductFullReductionExample example);

    int updateByExample(@Param("record") GoodsProductFullReduction record, @Param("example") GoodsProductFullReductionExample example);

    int updateByPrimaryKeySelective(GoodsProductFullReduction record);

    int updateByPrimaryKey(GoodsProductFullReduction record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<GoodsProductFullReduction> productFullReductionList);
}