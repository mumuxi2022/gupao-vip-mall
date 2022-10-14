package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserAdminRole;
import com.jt.model.UserAdminRoleExample;
import com.jt.model.UserResource;
import com.jt.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRoleMapper {
    long countByExample(UserAdminRoleExample example);

    int deleteByExample(UserAdminRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAdminRole record);

    int insertSelective(UserAdminRole record);

    List<UserAdminRole> selectByExample(UserAdminRoleExample example);

    UserAdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAdminRole record, @Param("example") UserAdminRoleExample example);

    int updateByExample(@Param("record") UserAdminRole record, @Param("example") UserAdminRoleExample example);

    int updateByPrimaryKeySelective(UserAdminRole record);

    int updateByPrimaryKey(UserAdminRole record);

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UserAdminRole> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<UserRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<UserResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}