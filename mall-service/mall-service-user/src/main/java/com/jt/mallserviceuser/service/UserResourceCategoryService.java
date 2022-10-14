package com.jt.mallserviceuser.service;

import com.jt.model.UserResourceCategory;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:11
 * 后台资源分类管理Service
 */
public interface UserResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UserResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UserResourceCategory UserResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UserResourceCategory UserResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
