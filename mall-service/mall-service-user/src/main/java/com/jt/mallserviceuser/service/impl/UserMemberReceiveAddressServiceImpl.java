package com.jt.mallserviceuser.service.impl;

import com.jt.mallserviceuser.mapper.UserMemberMapper;
import com.jt.mallserviceuser.mapper.UserMemberReceiveAddressMapper;
import com.jt.mallserviceuser.service.UserMemberReceiveAddressService;
import com.jt.mallserviceuser.service.UserMemberService;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:06
 * 收货地址Service实现类
 */
@Service
public class UserMemberReceiveAddressServiceImpl implements UserMemberReceiveAddressService {
    @Autowired
    private UserMemberReceiveAddressMapper userMemberReceiveAddressMapper;

    @Override
    public long countByExample(UserMemberReceiveAddressExample example) {
        return userMemberReceiveAddressMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserMemberReceiveAddressExample example) {
        return userMemberReceiveAddressMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMemberReceiveAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserMemberReceiveAddress record) {
        return userMemberReceiveAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMemberReceiveAddress record) {
        return userMemberReceiveAddressMapper.insertSelective(record);
    }

    @Override
    public List<UserMemberReceiveAddress> selectByExample(UserMemberReceiveAddressExample example) {
        return userMemberReceiveAddressMapper.selectByExample(example);
    }

    @Override
    public UserMemberReceiveAddress selectByPrimaryKey(Long id) {
        return userMemberReceiveAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserMemberReceiveAddress record, UserMemberReceiveAddressExample example) {
        return userMemberReceiveAddressMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserMemberReceiveAddress record, UserMemberReceiveAddressExample example) {
        return userMemberReceiveAddressMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMemberReceiveAddress record) {
        return userMemberReceiveAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMemberReceiveAddress record) {
        return userMemberReceiveAddressMapper.updateByPrimaryKey(record);
    }
}
