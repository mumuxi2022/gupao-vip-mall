package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextSubjectCategory;
import com.jt.model.ContextSubjectCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextSubjectCategoryMapper {
    long countByExample(ContextSubjectCategoryExample example);

    int deleteByExample(ContextSubjectCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextSubjectCategory record);

    int insertSelective(ContextSubjectCategory record);

    List<ContextSubjectCategory> selectByExample(ContextSubjectCategoryExample example);

    ContextSubjectCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextSubjectCategory record, @Param("example") ContextSubjectCategoryExample example);

    int updateByExample(@Param("record") ContextSubjectCategory record, @Param("example") ContextSubjectCategoryExample example);

    int updateByPrimaryKeySelective(ContextSubjectCategory record);

    int updateByPrimaryKey(ContextSubjectCategory record);
}