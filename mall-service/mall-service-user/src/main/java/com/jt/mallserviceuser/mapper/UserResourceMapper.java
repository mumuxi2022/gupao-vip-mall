package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserResource;
import com.jt.model.UserResourceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResourceMapper {
    long countByExample(UserResourceExample example);

    int deleteByExample(UserResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserResource record);

    int insertSelective(UserResource record);

    List<UserResource> selectByExample(UserResourceExample example);

    UserResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserResource record, @Param("example") UserResourceExample example);

    int updateByExample(@Param("record") UserResource record, @Param("example") UserResourceExample example);

    int updateByPrimaryKeySelective(UserResource record);

    int updateByPrimaryKey(UserResource record);
}