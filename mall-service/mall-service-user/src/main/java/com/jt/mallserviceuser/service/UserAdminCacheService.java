package com.jt.mallserviceuser.service;

import com.jt.model.UserAdmin;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:32
 * 后台用户缓存操作类
 */
public interface UserAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    UserAdmin getAdmin(Long adminId);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UserAdmin admin);
}
