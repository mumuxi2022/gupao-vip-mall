package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberLoginLog;
import com.jt.model.UserMemberLoginLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberLoginLogMapper {
    long countByExample(UserMemberLoginLogExample example);

    int deleteByExample(UserMemberLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberLoginLog record);

    int insertSelective(UserMemberLoginLog record);

    List<UserMemberLoginLog> selectByExample(UserMemberLoginLogExample example);

    UserMemberLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberLoginLog record, @Param("example") UserMemberLoginLogExample example);

    int updateByExample(@Param("record") UserMemberLoginLog record, @Param("example") UserMemberLoginLogExample example);

    int updateByPrimaryKeySelective(UserMemberLoginLog record);

    int updateByPrimaryKey(UserMemberLoginLog record);
}