package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.dto.ProductAttrInfo;
import com.jt.model.GoodsProductAttribute;
import com.jt.model.GoodsProductAttributeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductAttributeMapper {
    long countByExample(GoodsProductAttributeExample example);

    int deleteByExample(GoodsProductAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductAttribute record);

    int insertSelective(GoodsProductAttribute record);

    List<GoodsProductAttribute> selectByExample(GoodsProductAttributeExample example);

    GoodsProductAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductAttribute record, @Param("example") GoodsProductAttributeExample example);

    int updateByExample(@Param("record") GoodsProductAttribute record, @Param("example") GoodsProductAttributeExample example);

    int updateByPrimaryKeySelective(GoodsProductAttribute record);

    int updateByPrimaryKey(GoodsProductAttribute record);

    /**
     * 获取商品属性信息
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}