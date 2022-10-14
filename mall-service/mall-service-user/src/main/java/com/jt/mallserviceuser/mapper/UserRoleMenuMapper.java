package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserRoleMenu;
import com.jt.model.UserRoleMenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMenuMapper {
    long countByExample(UserRoleMenuExample example);

    int deleteByExample(UserRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRoleMenu record);

    int insertSelective(UserRoleMenu record);

    List<UserRoleMenu> selectByExample(UserRoleMenuExample example);

    UserRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRoleMenu record, @Param("example") UserRoleMenuExample example);

    int updateByExample(@Param("record") UserRoleMenu record, @Param("example") UserRoleMenuExample example);

    int updateByPrimaryKeySelective(UserRoleMenu record);

    int updateByPrimaryKey(UserRoleMenu record);
}