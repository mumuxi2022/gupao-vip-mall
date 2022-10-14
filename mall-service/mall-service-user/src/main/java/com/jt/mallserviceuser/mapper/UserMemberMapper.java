package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberMapper {
    long countByExample(UserMemberExample example);

    int deleteByExample(UserMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMember record);

    int insertSelective(UserMember record);

    List<UserMember> selectByExample(UserMemberExample example);

    UserMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMember record, @Param("example") UserMemberExample example);

    int updateByExample(@Param("record") UserMember record, @Param("example") UserMemberExample example);

    int updateByPrimaryKeySelective(UserMember record);

    int updateByPrimaryKey(UserMember record);
}