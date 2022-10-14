package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextTopicCategory;
import com.jt.model.ContextTopicCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextTopicCategoryMapper {
    long countByExample(ContextTopicCategoryExample example);

    int deleteByExample(ContextTopicCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextTopicCategory record);

    int insertSelective(ContextTopicCategory record);

    List<ContextTopicCategory> selectByExample(ContextTopicCategoryExample example);

    ContextTopicCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextTopicCategory record, @Param("example") ContextTopicCategoryExample example);

    int updateByExample(@Param("record") ContextTopicCategory record, @Param("example") ContextTopicCategoryExample example);

    int updateByPrimaryKeySelective(ContextTopicCategory record);

    int updateByPrimaryKey(ContextTopicCategory record);
}