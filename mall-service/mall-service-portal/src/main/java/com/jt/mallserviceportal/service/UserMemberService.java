package com.jt.mallserviceportal.service;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallcommon.domain.UserDto;
import com.jt.model.UserMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 */
public interface UserMemberService {
    /**
     * 根据用户名获取会员
     */
    UserMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UserMember getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    boolean verifyAuthCode(String authCode,String telephone);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     */
    UserMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);


    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    CommonResult login(String username, String password);
}
