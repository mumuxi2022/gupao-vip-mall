package com.jt.mallserviceuser.service.impl;

import com.jt.mallserviceuser.mapper.UserMemberLevelMapper;
import com.jt.mallserviceuser.service.UserMemberLevelService;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:06
 * 会员等级管理Service实现类
 */
@Service
public class UserMemberLevelServiceImpl implements UserMemberLevelService {
    @Autowired
    private UserMemberLevelMapper memberLevelMapper;
    @Override
    public List<UserMemberLevel> list(Integer defaultStatus) {
        UserMemberLevelExample example = new UserMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }

    @Override
    public long countByExample(UserMemberLevelExample example) {
        return memberLevelMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserMemberLevelExample example) {
        return memberLevelMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserMemberLevel record) {
        return memberLevelMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMemberLevel record) {
        return memberLevelMapper.insertSelective(record);
    }

    @Override
    public List<UserMemberLevel> selectByExample(UserMemberLevelExample example) {
        return memberLevelMapper.selectByExample(example);
    }

    @Override
    public UserMemberLevel selectByPrimaryKey(Long id) {
        return memberLevelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserMemberLevel record, UserMemberLevelExample example) {
        return memberLevelMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserMemberLevel record, UserMemberLevelExample example) {
        return memberLevelMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMemberLevel record) {
        return memberLevelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMemberLevel record) {
        return memberLevelMapper.updateByPrimaryKey(record);
    }
}
