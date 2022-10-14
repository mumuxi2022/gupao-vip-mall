package com.jt.mallserviceuser.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.jt.dto.UpdateAdminPasswordParam;
import com.jt.dto.UserAdminParam;
import com.jt.feign.AuthService;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallcommon.api.ResultCode;
import com.jt.mallcommon.constant.AuthConstant;
import com.jt.mallcommon.domain.UserDto;
import com.jt.mallcommon.exception.Asserts;
import com.jt.mallserviceuser.mapper.UserAdminLoginLogMapper;
import com.jt.mallserviceuser.mapper.UserAdminMapper;
import com.jt.mallserviceuser.mapper.UserAdminRoleMapper;
import com.jt.mallserviceuser.service.UserAdminCacheService;
import com.jt.mallserviceuser.service.UserAdminService;
import com.jt.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:23
 * UserAdminService实现类
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAdminServiceImpl.class);
    @Autowired
    private UserAdminMapper adminMapper;
    @Autowired
    private UserAdminRoleMapper adminRoleRelationMapper;
    @Autowired
    private UserAdminRoleMapper adminRoleMapper;
    @Autowired
    private UserAdminLoginLogMapper loginLogMapper;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserAdminCacheService adminCacheService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UserAdmin getAdminByUsername(String username) {
        UserAdminExample example = new UserAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public UserAdmin register(UserAdminParam UserAdminParam) {
        UserAdmin UserAdmin = new UserAdmin();
        BeanUtils.copyProperties(UserAdminParam, UserAdmin);
        UserAdmin.setCreateTime(new Date());
        UserAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        UserAdminExample example = new UserAdminExample();
        example.createCriteria().andUsernameEqualTo(UserAdmin.getUsername());
        List<UserAdmin> UserAdminList = adminMapper.selectByExample(example);
        if (UserAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(UserAdmin.getPassword());
        UserAdmin.setPassword(encodePassword);
        adminMapper.insert(UserAdmin);
        return UserAdmin;
    }

    @Override
    public CommonResult login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        CommonResult restResult = authService.getAccessToken(params);
        if(ResultCode.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        }
        return restResult;
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UserAdmin admin = getAdminByUsername(username);
        if(admin==null) return;
        UserAdminLoginLog loginLog = new UserAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        UserAdmin record = new UserAdmin();
        record.setLoginTime(new Date());
        UserAdminExample example = new UserAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public UserAdmin getItem(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserAdminExample example = new UserAdminExample();
        UserAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        return adminMapper.selectByExample(example);
    }

    @Override
    public int update(Long id, UserAdmin admin) {
        admin.setId(id);
        UserAdmin rawAdmin = adminMapper.selectByPrimaryKey(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = adminMapper.deleteByPrimaryKey(id);
        adminCacheService.delAdmin(id);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        UserAdminRoleExample adminRoleRelationExample = new UserAdminRoleExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UserAdminRole> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UserAdminRole roleRelation = new UserAdminRole();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleMapper.insertList(list);
        }
        return count;
    }

    @Override
    public List<UserRole> getRoleList(Long adminId) {
        return adminRoleMapper.getRoleList(adminId);
    }

    @Override
    public List<UserResource> getResourceList(Long adminId) {
        return adminRoleMapper.getResourceList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            return -1;
        }
        UserAdminExample example = new UserAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername());
        List<UserAdmin> adminList = adminMapper.selectByExample(example);
        if(CollUtil.isEmpty(adminList)){
            return -2;
        }
        UserAdmin UserAdmin = adminList.get(0);
        if(!BCrypt.checkpw(param.getOldPassword(),UserAdmin.getPassword())){
            return -3;
        }
        UserAdmin.setPassword(BCrypt.hashpw(param.getNewPassword()));
        adminMapper.updateByPrimaryKey(UserAdmin);
        adminCacheService.delAdmin(UserAdmin.getId());
        return 1;
    }

    @Override
    public UserDto loadUserByUsername(String username){
        //获取用户信息
        UserAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UserRole> roleList = getRoleList(admin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(admin,userDTO);
            if(CollUtil.isNotEmpty(roleList)){
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }

    @Override
    public UserAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UserAdmin admin = adminCacheService.getAdmin(userDto.getId());
        if(admin!=null){
            return admin;
        }else{
            admin = adminMapper.selectByPrimaryKey(userDto.getId());
            adminCacheService.setAdmin(admin);
            return admin;
        }
    }
}
