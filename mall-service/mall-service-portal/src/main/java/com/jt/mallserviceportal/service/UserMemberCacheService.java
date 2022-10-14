package com.jt.mallserviceportal.service;


import com.jt.model.UserMember;

/**
 * 会员信息缓存业务类
 */
public interface UserMemberCacheService {
    /**
     * 删除会员用户缓存
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     */
    UserMember getMember(Long memberId);

    /**
     * 设置会员用户缓存
     */
    void setMember(UserMember member);

    /**
     * 设置验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);
}
