package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberTagRelation;
import com.jt.model.UserMemberTagRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberTagRelationMapper {
    long countByExample(UserMemberTagRelationExample example);

    int deleteByExample(UserMemberTagRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberTagRelation record);

    int insertSelective(UserMemberTagRelation record);

    List<UserMemberTagRelation> selectByExample(UserMemberTagRelationExample example);

    UserMemberTagRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberTagRelation record, @Param("example") UserMemberTagRelationExample example);

    int updateByExample(@Param("record") UserMemberTagRelation record, @Param("example") UserMemberTagRelationExample example);

    int updateByPrimaryKeySelective(UserMemberTagRelation record);

    int updateByPrimaryKey(UserMemberTagRelation record);
}