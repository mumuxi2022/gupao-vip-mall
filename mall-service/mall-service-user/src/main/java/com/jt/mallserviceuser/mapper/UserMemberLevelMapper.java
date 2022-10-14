package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberLevelMapper {
    long countByExample(UserMemberLevelExample example);

    int deleteByExample(UserMemberLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberLevel record);

    int insertSelective(UserMemberLevel record);

    List<UserMemberLevel> selectByExample(UserMemberLevelExample example);

    UserMemberLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberLevel record, @Param("example") UserMemberLevelExample example);

    int updateByExample(@Param("record") UserMemberLevel record, @Param("example") UserMemberLevelExample example);

    int updateByPrimaryKeySelective(UserMemberLevel record);

    int updateByPrimaryKey(UserMemberLevel record);
}