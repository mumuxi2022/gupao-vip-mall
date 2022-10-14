package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextSubjectComment;
import com.jt.model.ContextSubjectCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextSubjectCommentMapper {
    long countByExample(ContextSubjectCommentExample example);

    int deleteByExample(ContextSubjectCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextSubjectComment record);

    int insertSelective(ContextSubjectComment record);

    List<ContextSubjectComment> selectByExample(ContextSubjectCommentExample example);

    ContextSubjectComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextSubjectComment record, @Param("example") ContextSubjectCommentExample example);

    int updateByExample(@Param("record") ContextSubjectComment record, @Param("example") ContextSubjectCommentExample example);

    int updateByPrimaryKeySelective(ContextSubjectComment record);

    int updateByPrimaryKey(ContextSubjectComment record);
}