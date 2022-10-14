package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.dto.GoodsProductAttributeCategoryItem;
import com.jt.model.GoodsProductAttributeCategory;
import com.jt.model.GoodsProductAttributeCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductAttributeCategoryMapper {
    long countByExample(GoodsProductAttributeCategoryExample example);

    int deleteByExample(GoodsProductAttributeCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductAttributeCategory record);

    int insertSelective(GoodsProductAttributeCategory record);

    List<GoodsProductAttributeCategory> selectByExample(GoodsProductAttributeCategoryExample example);

    GoodsProductAttributeCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductAttributeCategory record, @Param("example") GoodsProductAttributeCategoryExample example);

    int updateByExample(@Param("record") GoodsProductAttributeCategory record, @Param("example") GoodsProductAttributeCategoryExample example);

    int updateByPrimaryKeySelective(GoodsProductAttributeCategory record);

    int updateByPrimaryKey(GoodsProductAttributeCategory record);

    //获取包含属性的商品属性分类
    List<GoodsProductAttributeCategoryItem> getListWithAttr();
}