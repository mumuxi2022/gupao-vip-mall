package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberProductCategory;
import com.jt.model.UserMemberProductCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberProductCategoryMapper {
    long countByExample(UserMemberProductCategoryExample example);

    int deleteByExample(UserMemberProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberProductCategory record);

    int insertSelective(UserMemberProductCategory record);

    List<UserMemberProductCategory> selectByExample(UserMemberProductCategoryExample example);

    UserMemberProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberProductCategory record, @Param("example") UserMemberProductCategoryExample example);

    int updateByExample(@Param("record") UserMemberProductCategory record, @Param("example") UserMemberProductCategoryExample example);

    int updateByPrimaryKeySelective(UserMemberProductCategory record);

    int updateByPrimaryKey(UserMemberProductCategory record);
}