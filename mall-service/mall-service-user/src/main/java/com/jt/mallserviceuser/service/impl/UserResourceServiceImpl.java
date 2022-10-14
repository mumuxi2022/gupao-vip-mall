package com.jt.mallserviceuser.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.jt.mallcommon.constant.AuthConstant;
import com.jt.mallcommon.service.RedisService;
import com.jt.mallserviceuser.mapper.UserResourceMapper;
import com.jt.mallserviceuser.mapper.UserRoleMapper;
import com.jt.mallserviceuser.mapper.UserRoleResourceMapper;
import com.jt.mallserviceuser.service.UserResourceService;
import com.jt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 后台资源管理Service实现类
 */
@Service
public class UserResourceServiceImpl implements UserResourceService {
    @Autowired
    private UserResourceMapper resourceMapper;
    @Autowired
    private UserRoleMapper roleMapper;
    @Autowired
    private UserRoleResourceMapper roleResourceRelationMapper;
    @Autowired
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;
    @Override
    public int create(UserResource userResource) {
        userResource.setCreateTime(new Date());
        int count = resourceMapper.insert(userResource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public int update(Long id, UserResource UserResource) {
        UserResource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(UserResource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public UserResource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        initResourceRolesMap();
        return count;
    }

    @Override
    public List<UserResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UserResourceExample example = new UserResourceExample();
        UserResourceExample.Criteria criteria = example.createCriteria();
        if(categoryId!=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andUrlLike('%'+urlKeyword+'%');
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<UserResource> listAll() {
        return resourceMapper.selectByExample(new UserResourceExample());
    }

    @Override
    public Map<String,List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<UserResource> resourceList = resourceMapper.selectByExample(new UserResourceExample());
        List<UserRole> roleList = roleMapper.selectByExample(new UserRoleExample());
        List<UserRoleResource> relationList = roleResourceRelationMapper.selectByExample(new UserRoleResourceExample());
        for (UserResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UserRoleResource::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;

    }
}
