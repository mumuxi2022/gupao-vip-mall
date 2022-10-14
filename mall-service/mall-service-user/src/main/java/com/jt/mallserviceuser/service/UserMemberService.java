package com.jt.mallserviceuser.service;

import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:03
 * 会员管理Service
 */
public interface UserMemberService {
    long countByExample(UserMemberExample example);

    int deleteByExample(UserMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMember record);

    int insertSelective(UserMember record);

    List<UserMember> selectByExample(UserMemberExample example);

    UserMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserMember record, UserMemberExample example);

    int updateByExample(UserMember record, UserMemberExample example);

    int updateByPrimaryKeySelective(UserMember record);

    int updateByPrimaryKey(UserMember record);
}
