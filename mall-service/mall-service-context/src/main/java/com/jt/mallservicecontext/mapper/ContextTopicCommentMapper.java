package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextTopicComment;
import com.jt.model.ContextTopicCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextTopicCommentMapper {
    long countByExample(ContextTopicCommentExample example);

    int deleteByExample(ContextTopicCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextTopicComment record);

    int insertSelective(ContextTopicComment record);

    List<ContextTopicComment> selectByExample(ContextTopicCommentExample example);

    ContextTopicComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextTopicComment record, @Param("example") ContextTopicCommentExample example);

    int updateByExample(@Param("record") ContextTopicComment record, @Param("example") ContextTopicCommentExample example);

    int updateByPrimaryKeySelective(ContextTopicComment record);

    int updateByPrimaryKey(ContextTopicComment record);
}