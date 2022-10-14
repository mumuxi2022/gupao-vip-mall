package com.jt.mallserviceuser.service;

import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:03
 * 会员等级管理Service
 */
public interface UserMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UserMemberLevel> list(Integer defaultStatus);

    long countByExample(UserMemberLevelExample example);

    int deleteByExample(UserMemberLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberLevel record);

    int insertSelective(UserMemberLevel record);

    List<UserMemberLevel> selectByExample(UserMemberLevelExample example);

    UserMemberLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserMemberLevel record, UserMemberLevelExample example);

    int updateByExample(UserMemberLevel record, UserMemberLevelExample example);

    int updateByPrimaryKeySelective(UserMemberLevel record);

    int updateByPrimaryKey(UserMemberLevel record);
}
