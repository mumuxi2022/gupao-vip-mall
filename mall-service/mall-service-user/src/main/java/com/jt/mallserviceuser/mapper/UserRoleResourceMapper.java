package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserRoleResource;
import com.jt.model.UserRoleResourceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleResourceMapper {
    long countByExample(UserRoleResourceExample example);

    int deleteByExample(UserRoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRoleResource record);

    int insertSelective(UserRoleResource record);

    List<UserRoleResource> selectByExample(UserRoleResourceExample example);

    UserRoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRoleResource record, @Param("example") UserRoleResourceExample example);

    int updateByExample(@Param("record") UserRoleResource record, @Param("example") UserRoleResourceExample example);

    int updateByPrimaryKeySelective(UserRoleResource record);

    int updateByPrimaryKey(UserRoleResource record);
}