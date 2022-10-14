package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextSubjectProductRelation;
import com.jt.model.ContextSubjectProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextSubjectProductRelationMapper {
    long countByExample(ContextSubjectProductRelationExample example);

    int deleteByExample(ContextSubjectProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextSubjectProductRelation record);

    int insertSelective(ContextSubjectProductRelation record);

    List<ContextSubjectProductRelation> selectByExample(ContextSubjectProductRelationExample example);

    ContextSubjectProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextSubjectProductRelation record, @Param("example") ContextSubjectProductRelationExample example);

    int updateByExample(@Param("record") ContextSubjectProductRelation record, @Param("example") ContextSubjectProductRelationExample example);

    int updateByPrimaryKeySelective(ContextSubjectProductRelation record);

    int updateByPrimaryKey(ContextSubjectProductRelation record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<ContextSubjectProductRelation> subjectProductRelationList);

    List<ContextSubjectProductRelation> getListByProductId(Long productId);
}