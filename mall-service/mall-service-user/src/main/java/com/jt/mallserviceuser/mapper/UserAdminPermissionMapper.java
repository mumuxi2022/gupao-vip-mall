package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserAdminPermission;
import com.jt.model.UserAdminPermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminPermissionMapper {
    long countByExample(UserAdminPermissionExample example);

    int deleteByExample(UserAdminPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAdminPermission record);

    int insertSelective(UserAdminPermission record);

    List<UserAdminPermission> selectByExample(UserAdminPermissionExample example);

    UserAdminPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAdminPermission record, @Param("example") UserAdminPermissionExample example);

    int updateByExample(@Param("record") UserAdminPermission record, @Param("example") UserAdminPermissionExample example);

    int updateByPrimaryKeySelective(UserAdminPermission record);

    int updateByPrimaryKey(UserAdminPermission record);
}