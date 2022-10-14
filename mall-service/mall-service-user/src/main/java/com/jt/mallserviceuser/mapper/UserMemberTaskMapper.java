package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberTask;
import com.jt.model.UserMemberTaskExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberTaskMapper {
    long countByExample(UserMemberTaskExample example);

    int deleteByExample(UserMemberTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberTask record);

    int insertSelective(UserMemberTask record);

    List<UserMemberTask> selectByExample(UserMemberTaskExample example);

    UserMemberTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberTask record, @Param("example") UserMemberTaskExample example);

    int updateByExample(@Param("record") UserMemberTask record, @Param("example") UserMemberTaskExample example);

    int updateByPrimaryKeySelective(UserMemberTask record);

    int updateByPrimaryKey(UserMemberTask record);
}