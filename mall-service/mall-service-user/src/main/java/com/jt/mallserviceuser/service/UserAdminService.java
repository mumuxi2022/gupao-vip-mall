package com.jt.mallserviceuser.service;

import com.jt.dto.UpdateAdminPasswordParam;
import com.jt.dto.UserAdminParam;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallcommon.domain.UserDto;
import com.jt.model.UserAdmin;
import com.jt.model.UserResource;
import com.jt.model.UserRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 10:16
 * 后台管理员Service
 */
public interface UserAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UserAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UserAdmin register(UserAdminParam UserAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户id获取用户
     */
    UserAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UserAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UserAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<UserRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<UserResource> getResourceList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     */
    UserAdmin getCurrentAdmin();
}
