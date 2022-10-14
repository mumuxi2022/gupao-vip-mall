package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductAttributeValue;
import com.jt.model.GoodsProductAttributeValueExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductAttributeValueMapper {
    long countByExample(GoodsProductAttributeValueExample example);

    int deleteByExample(GoodsProductAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductAttributeValue record);

    int insertSelective(GoodsProductAttributeValue record);

    List<GoodsProductAttributeValue> selectByExample(GoodsProductAttributeValueExample example);

    GoodsProductAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductAttributeValue record, @Param("example") GoodsProductAttributeValueExample example);

    int updateByExample(@Param("record") GoodsProductAttributeValue record, @Param("example") GoodsProductAttributeValueExample example);

    int updateByPrimaryKeySelective(GoodsProductAttributeValue record);

    int updateByPrimaryKey(GoodsProductAttributeValue record);
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<GoodsProductAttributeValue> productAttributeValueList);
}