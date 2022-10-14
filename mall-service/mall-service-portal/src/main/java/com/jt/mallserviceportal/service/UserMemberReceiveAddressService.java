package com.jt.mallserviceportal.service;

import com.jt.model.UserMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户地址管理Service
 */
public interface UserMemberReceiveAddressService {
    /**
     * 添加收货地址
     */
    int add(UserMemberReceiveAddress address);

    /**
     * 删除收货地址
     * @param id 地址表的id
     */
    int delete(Long id);

    /**
     * 修改收货地址
     * @param id 地址表的id
     * @param address 修改的收货地址信息
     */
    @Transactional
    int update(Long id, UserMemberReceiveAddress address);

    /**
     * 返回当前用户的收货地址
     */
    List<UserMemberReceiveAddress> list();

    /**
     * 获取地址详情
     * @param id 地址id
     */
    UserMemberReceiveAddress getItem(Long id);
}
