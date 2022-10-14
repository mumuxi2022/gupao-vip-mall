package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextTopic;
import com.jt.model.ContextTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextTopicMapper {
    long countByExample(ContextTopicExample example);

    int deleteByExample(ContextTopicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextTopic record);

    int insertSelective(ContextTopic record);

    List<ContextTopic> selectByExampleWithBLOBs(ContextTopicExample example);

    List<ContextTopic> selectByExample(ContextTopicExample example);

    ContextTopic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextTopic record, @Param("example") ContextTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") ContextTopic record, @Param("example") ContextTopicExample example);

    int updateByExample(@Param("record") ContextTopic record, @Param("example") ContextTopicExample example);

    int updateByPrimaryKeySelective(ContextTopic record);

    int updateByPrimaryKeyWithBLOBs(ContextTopic record);

    int updateByPrimaryKey(ContextTopic record);
}