package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextHelpCategory;
import com.jt.model.ContextHelpCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextHelpCategoryMapper {
    long countByExample(ContextHelpCategoryExample example);

    int deleteByExample(ContextHelpCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextHelpCategory record);

    int insertSelective(ContextHelpCategory record);

    List<ContextHelpCategory> selectByExample(ContextHelpCategoryExample example);

    ContextHelpCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextHelpCategory record, @Param("example") ContextHelpCategoryExample example);

    int updateByExample(@Param("record") ContextHelpCategory record, @Param("example") ContextHelpCategoryExample example);

    int updateByPrimaryKeySelective(ContextHelpCategory record);

    int updateByPrimaryKey(ContextHelpCategory record);
}