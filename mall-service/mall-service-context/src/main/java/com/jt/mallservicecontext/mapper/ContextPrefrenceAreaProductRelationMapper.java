package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextPrefrenceAreaProductRelationMapper {
    long countByExample(ContextPrefrenceAreaProductRelationExample example);

    int deleteByExample(ContextPrefrenceAreaProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextPrefrenceAreaProductRelation record);

    int insertSelective(ContextPrefrenceAreaProductRelation record);

    List<ContextPrefrenceAreaProductRelation> selectByExample(ContextPrefrenceAreaProductRelationExample example);

    ContextPrefrenceAreaProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextPrefrenceAreaProductRelation record, @Param("example") ContextPrefrenceAreaProductRelationExample example);

    int updateByExample(@Param("record") ContextPrefrenceAreaProductRelation record, @Param("example") ContextPrefrenceAreaProductRelationExample example);

    int updateByPrimaryKeySelective(ContextPrefrenceAreaProductRelation record);

    int updateByPrimaryKey(ContextPrefrenceAreaProductRelation record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ContextPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);

    List<ContextPrefrenceAreaProductRelation> getListByProductId(Long productId);
}