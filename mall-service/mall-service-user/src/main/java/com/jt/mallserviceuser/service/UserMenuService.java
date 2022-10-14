package com.jt.mallserviceuser.service;

import com.jt.dto.UserMenuNode;
import com.jt.model.UserMenu;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 17:56
 * 后台菜单管理Service
 */
public interface UserMenuService {
    /**
     * 创建后台菜单
     */
    int create(UserMenu UserMenu);

    /**
     * 修改后台菜单
     */
    int update(Long id, UserMenu UserMenu);

    /**
     * 根据ID获取菜单详情
     */
    UserMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<UserMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UserMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
