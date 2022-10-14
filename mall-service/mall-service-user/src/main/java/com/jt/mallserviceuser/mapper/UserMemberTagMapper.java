package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberTag;
import com.jt.model.UserMemberTagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberTagMapper {
    long countByExample(UserMemberTagExample example);

    int deleteByExample(UserMemberTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberTag record);

    int insertSelective(UserMemberTag record);

    List<UserMemberTag> selectByExample(UserMemberTagExample example);

    UserMemberTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberTag record, @Param("example") UserMemberTagExample example);

    int updateByExample(@Param("record") UserMemberTag record, @Param("example") UserMemberTagExample example);

    int updateByPrimaryKeySelective(UserMemberTag record);

    int updateByPrimaryKey(UserMemberTag record);
}