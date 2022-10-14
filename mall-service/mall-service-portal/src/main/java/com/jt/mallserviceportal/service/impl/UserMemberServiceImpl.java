package com.jt.mallserviceportal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.jt.feign.AuthService;
import com.jt.feign.UserMemberFeign;
import com.jt.feign.UserMemberLevelFeign;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallcommon.api.ResultCode;
import com.jt.mallcommon.constant.AuthConstant;
import com.jt.mallcommon.domain.UserDto;
import com.jt.mallcommon.exception.Asserts;
import com.jt.mallserviceportal.service.UserMemberCacheService;
import com.jt.mallserviceportal.service.UserMemberService;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 会员管理Service实现类
 */
@Service
public class UserMemberServiceImpl implements UserMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMemberServiceImpl.class);
    @Autowired
    private UserMemberFeign memberFeign;
    @Autowired
    private UserMemberLevelFeign memberLevelFeign;
    @Autowired
    private UserMemberCacheService memberCacheService;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Autowired
    private AuthService authService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UserMember getByUsername(String username) {
        UserMemberExample example = new UserMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserMember> memberList = memberFeign.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UserMember getById(Long id) {
        return memberFeign.selectByPrimaryKey(id);
    }

    @Override
    public void register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            Asserts.fail("验证码错误");
        }
        //查询是否已有该用户
        UserMemberExample example = new UserMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UserMember> userMembers = memberFeign.selectByExample(example);
        if (!CollectionUtils.isEmpty(userMembers)) {
            Asserts.fail("该用户已经存在");
        }
        //没有该用户进行添加操作
        UserMember userMember = new UserMember();
        userMember.setUsername(username);
        userMember.setPhone(telephone);
        userMember.setPassword(BCrypt.hashpw(password));
        userMember.setCreateTime(new Date());
        userMember.setStatus(1);
        //获取默认会员等级并设置
        UserMemberLevelExample levelExample = new UserMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UserMemberLevel> memberLevelList = memberLevelFeign.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            userMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberFeign.insert(userMember);
        userMember.setPassword(null);
    }

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(telephone,sb.toString());
        return sb.toString();
    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {
        UserMemberExample example = new UserMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UserMember> memberList = memberFeign.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            Asserts.fail("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            Asserts.fail("验证码错误");
        }
        UserMember userMember = memberList.get(0);
        userMember.setPassword(BCrypt.hashpw(password));
        memberFeign.updateByPrimaryKeySelective(userMember);
        memberCacheService.delMember(userMember.getId());
    }

    @Override
    public UserMember getCurrentMember() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UserMember member = memberCacheService.getMember(userDto.getId());
        if(member!=null){
            return member;
        }else{
            member = getById(userDto.getId());
            memberCacheService.setMember(member);
            return member;
        }
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UserMember record=new UserMember();
        record.setId(id);
        record.setIntegration(integration);
        memberFeign.updateByPrimaryKeySelective(record);
        memberCacheService.delMember(id);
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        UserMember member = getByUsername(username);
        if(member!=null){
            UserDto userDto = new UserDto();
            BeanUtil.copyProperties(member,userDto);
            userDto.setRoles(CollUtil.toList("前台会员"));
            return userDto;
        }
        return null;
    }

    @Override
    public CommonResult login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.PORTAL_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        return authService.getAccessToken(params);
    }

    //对输入的验证码进行校验
    @Override
    public boolean verifyAuthCode(String authCode, String telephone){
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }

}
