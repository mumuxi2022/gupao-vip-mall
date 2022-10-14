package com.jt.mallserviceuser.service;

import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:03
 * 收货地址Service
 */
public interface UserMemberReceiveAddressService {
    long countByExample(UserMemberReceiveAddressExample example);

    int deleteByExample(UserMemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberReceiveAddress record);

    int insertSelective(UserMemberReceiveAddress record);

    List<UserMemberReceiveAddress> selectByExample(UserMemberReceiveAddressExample example);

    UserMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserMemberReceiveAddress record, UserMemberReceiveAddressExample example);

    int updateByExample(UserMemberReceiveAddress record,UserMemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(UserMemberReceiveAddress record);

    int updateByPrimaryKey(UserMemberReceiveAddress record);
}
