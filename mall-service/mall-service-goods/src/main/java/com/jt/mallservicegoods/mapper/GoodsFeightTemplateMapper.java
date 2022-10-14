package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsFeightTemplate;
import com.jt.model.GoodsFeightTemplateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsFeightTemplateMapper {
    long countByExample(GoodsFeightTemplateExample example);

    int deleteByExample(GoodsFeightTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsFeightTemplate record);

    int insertSelective(GoodsFeightTemplate record);

    List<GoodsFeightTemplate> selectByExample(GoodsFeightTemplateExample example);

    GoodsFeightTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsFeightTemplate record, @Param("example") GoodsFeightTemplateExample example);

    int updateByExample(@Param("record") GoodsFeightTemplate record, @Param("example") GoodsFeightTemplateExample example);

    int updateByPrimaryKeySelective(GoodsFeightTemplate record);

    int updateByPrimaryKey(GoodsFeightTemplate record);
}