package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserAdminLoginLog;
import com.jt.model.UserAdminLoginLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminLoginLogMapper {
    long countByExample(UserAdminLoginLogExample example);

    int deleteByExample(UserAdminLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAdminLoginLog record);

    int insertSelective(UserAdminLoginLog record);

    List<UserAdminLoginLog> selectByExample(UserAdminLoginLogExample example);

    UserAdminLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAdminLoginLog record, @Param("example") UserAdminLoginLogExample example);

    int updateByExample(@Param("record") UserAdminLoginLog record, @Param("example") UserAdminLoginLogExample example);

    int updateByPrimaryKeySelective(UserAdminLoginLog record);

    int updateByPrimaryKey(UserAdminLoginLog record);
}