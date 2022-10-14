package com.jt.mallserviceuser.service.impl;

import com.jt.mallserviceuser.mapper.UserMemberLevelMapper;
import com.jt.mallserviceuser.mapper.UserMemberMapper;
import com.jt.mallserviceuser.service.UserMemberLevelService;
import com.jt.mallserviceuser.service.UserMemberService;
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
 * 会员管理Service实现类
 */
@Service
public class UserMemberServiceImpl implements UserMemberService {
    @Autowired
    private UserMemberMapper memberMapper;

    @Override
    public long countByExample(UserMemberExample example) {
        return memberMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserMemberExample example) {
        return memberMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserMember record) {
        return memberMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMember record) {
        return memberMapper.insertSelective(record);
    }

    @Override
    public List<UserMember> selectByExample(UserMemberExample example) {
        return memberMapper.selectByExample(example);
    }

    @Override
    public UserMember selectByPrimaryKey(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserMember record, UserMemberExample example) {
        return memberMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserMember record, UserMemberExample example) {
        return memberMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMember record) {
        return memberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMember record) {
        return memberMapper.updateByPrimaryKey(record);
    }
}
