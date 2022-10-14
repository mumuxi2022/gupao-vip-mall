package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductCategoryAttributeRelation;
import com.jt.model.GoodsProductCategoryAttributeRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductCategoryAttributeRelationMapper {
    long countByExample(GoodsProductCategoryAttributeRelationExample example);

    int deleteByExample(GoodsProductCategoryAttributeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductCategoryAttributeRelation record);

    int insertSelective(GoodsProductCategoryAttributeRelation record);

    List<GoodsProductCategoryAttributeRelation> selectByExample(GoodsProductCategoryAttributeRelationExample example);

    GoodsProductCategoryAttributeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductCategoryAttributeRelation record, @Param("example") GoodsProductCategoryAttributeRelationExample example);

    int updateByExample(@Param("record") GoodsProductCategoryAttributeRelation record, @Param("example") GoodsProductCategoryAttributeRelationExample example);

    int updateByPrimaryKeySelective(GoodsProductCategoryAttributeRelation record);

    int updateByPrimaryKey(GoodsProductCategoryAttributeRelation record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<GoodsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}