package com.jt.mallserviceportal.service.impl;

import com.jt.feign.UserMemberReceiveAddressFeign;
import com.jt.mallserviceportal.service.UserMemberReceiveAddressService;
import com.jt.mallserviceportal.service.UserMemberService;
import com.jt.model.UserMember;
import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户地址管理Service实现类
 */
@Service
public class UserMemberReceiveAddressServiceImpl implements UserMemberReceiveAddressService {
    @Autowired
    private UserMemberService memberService;
    @Autowired
    private UserMemberReceiveAddressFeign userMemberReceiveAddressFeign;
    @Override
    public int add(UserMemberReceiveAddress address) {
        UserMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        return userMemberReceiveAddressFeign.insert(address);
    }

    @Override
    public int delete(Long id) {
        UserMember currentMember = memberService.getCurrentMember();
        UserMemberReceiveAddressExample example = new UserMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return userMemberReceiveAddressFeign.deleteByExample(example);
    }

    @Override
    public int update(Long id, UserMemberReceiveAddress address) {
        address.setId(null);
        UserMember currentMember = memberService.getCurrentMember();
        UserMemberReceiveAddressExample example = new UserMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        Map<String,Object> map = new HashMap();
        if(address.getDefaultStatus()==1){
            //先将原来的默认地址去除
            UserMemberReceiveAddress record= new UserMemberReceiveAddress();
            record.setDefaultStatus(0);
            UserMemberReceiveAddressExample updateExample = new UserMemberReceiveAddressExample();
            updateExample.createCriteria()
                    .andMemberIdEqualTo(currentMember.getId())
                    .andDefaultStatusEqualTo(1);
            map.put("UserMemberReceiveAddress",record);
            map.put("UserMemberReceiveAddressExample",example);
            userMemberReceiveAddressFeign.updateByExampleSelective(map);
        }
        map.put("UserMemberReceiveAddress",address);
        map.put("UserMemberReceiveAddressExample",example);
        return userMemberReceiveAddressFeign.updateByExampleSelective(map);
    }

    @Override
    public List<UserMemberReceiveAddress> list() {
        UserMember currentMember = memberService.getCurrentMember();
        UserMemberReceiveAddressExample example = new UserMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return userMemberReceiveAddressFeign.selectByExample(example);
    }

    @Override
    public UserMemberReceiveAddress getItem(Long id) {
        UserMember currentMember = memberService.getCurrentMember();
        UserMemberReceiveAddressExample example = new UserMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<UserMemberReceiveAddress> addressList = userMemberReceiveAddressFeign.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }
}
