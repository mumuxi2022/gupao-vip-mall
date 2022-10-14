package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserRolePermission;
import com.jt.model.UserRolePermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolePermissionMapper {
    long countByExample(UserRolePermissionExample example);

    int deleteByExample(UserRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRolePermission record);

    int insertSelective(UserRolePermission record);

    List<UserRolePermission> selectByExample(UserRolePermissionExample example);

    UserRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRolePermission record, @Param("example") UserRolePermissionExample example);

    int updateByExample(@Param("record") UserRolePermission record, @Param("example") UserRolePermissionExample example);

    int updateByPrimaryKeySelective(UserRolePermission record);

    int updateByPrimaryKey(UserRolePermission record);
}