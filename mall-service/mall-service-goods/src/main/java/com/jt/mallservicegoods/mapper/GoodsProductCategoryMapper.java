package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.dto.GoodsProductCategoryWithChildrenItem;
import com.jt.model.GoodsProductCategory;
import com.jt.model.GoodsProductCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductCategoryMapper {
    long countByExample(GoodsProductCategoryExample example);

    int deleteByExample(GoodsProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductCategory record);

    int insertSelective(GoodsProductCategory record);

    List<GoodsProductCategory> selectByExampleWithBLOBs(GoodsProductCategoryExample example);

    List<GoodsProductCategory> selectByExample(GoodsProductCategoryExample example);

    GoodsProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductCategory record, @Param("example") GoodsProductCategoryExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsProductCategory record, @Param("example") GoodsProductCategoryExample example);

    int updateByExample(@Param("record") GoodsProductCategory record, @Param("example") GoodsProductCategoryExample example);

    int updateByPrimaryKeySelective(GoodsProductCategory record);

    int updateByPrimaryKeyWithBLOBs(GoodsProductCategory record);

    int updateByPrimaryKey(GoodsProductCategory record);

    /**
     * 获取商品分类及其子分类
     */
    List<GoodsProductCategoryWithChildrenItem> listWithChildren();
}