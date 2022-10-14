package com.jt.mallserviceuser.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallserviceuser.mapper.UserRoleMapper;
import com.jt.mallserviceuser.mapper.UserRoleMenuMapper;
import com.jt.mallserviceuser.mapper.UserRoleResourceMapper;
import com.jt.mallserviceuser.service.UserResourceService;
import com.jt.mallserviceuser.service.UserRoleService;
import com.jt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 17:00
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper roleMapper;
    @Autowired
    private UserRoleMenuMapper roleMenuRelationMapper;
    @Autowired
    private UserRoleResourceMapper roleResourceRelationMapper;
    @Autowired
    private UserResourceService resourceService;
    @Override
    public int create(UserRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, UserRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Long> ids) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andIdIn(ids);
        int count = roleMapper.deleteByExample(example);
        resourceService.initResourceRolesMap();
        return count;
    }

    @Override
    public List<UserRole> list() {
        return roleMapper.selectByExample(new UserRoleExample());
    }

    @Override
    public List<UserRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserRoleExample example = new UserRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<UserMenu> getMenuList(Long adminId) {
        return roleMapper.getMenuList(adminId);
    }

    @Override
    public List<UserMenu> listMenu(Long roleId) {
        return roleMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UserResource> listResource(Long roleId) {
        return roleMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        UserRoleMenuExample example=new UserRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UserRoleMenu relation = new UserRoleMenu();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        UserRoleResourceExample example=new UserRoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UserRoleResource relation = new UserRoleResource();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        resourceService.initResourceRolesMap();
        return resourceIds.size();
    }
}
