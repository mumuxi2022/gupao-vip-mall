package com.jt.mallserviceuser.service;


import com.jt.model.UserResource;

import java.util.List;
import java.util.Map;

/**
 * 后台资源管理Service
 */
public interface UserResourceService {
    /**
     * 添加资源
     */
    int create(UserResource UserResource);

    /**
     * 修改资源
     */
    int update(Long id, UserResource UserResource);

    /**
     * 获取资源详情
     */
    UserResource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<UserResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 查询全部资源
     */
    List<UserResource> listAll();

    /**
     * 初始化资源角色规则
     */
    Map<String,List<String>> initResourceRolesMap();
}
