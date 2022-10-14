package com.jt.mallserviceuser.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.UserMenuNode;
import com.jt.mallserviceuser.mapper.UserMenuMapper;
import com.jt.mallserviceuser.service.UserMenuService;
import com.jt.model.UserMenu;
import com.jt.model.UserMenuExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 17:59
 * 后台菜单管理Service实现类
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {
    @Autowired
    private UserMenuMapper menuMapper;

    @Override
    public int create(UserMenu UserMenu) {
        UserMenu.setCreateTime(new Date());
        updateLevel(UserMenu);
        return menuMapper.insert(UserMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UserMenu UserMenu) {
        if (UserMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            UserMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UserMenu parentMenu = menuMapper.selectByPrimaryKey(UserMenu.getParentId());
            if (parentMenu != null) {
                UserMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                UserMenu.setLevel(0);
            }
        }
    }

    @Override
    public int update(Long id, UserMenu UserMenu) {
        UserMenu.setId(id);
        updateLevel(UserMenu);
        return menuMapper.updateByPrimaryKeySelective(UserMenu);
    }

    @Override
    public UserMenu getItem(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserMenuExample example = new UserMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<UserMenuNode> treeList() {
        List<UserMenu> menuList = menuMapper.selectByExample(new UserMenuExample());
        List<UserMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UserMenu UserMenu = new UserMenu();
        UserMenu.setId(id);
        UserMenu.setHidden(hidden);
        return menuMapper.updateByPrimaryKeySelective(UserMenu);
    }

    /**
     * 将UserMenu转化为UserMenuNode并设置children属性
     */
    private UserMenuNode covertMenuNode(UserMenu menu, List<UserMenu> menuList) {
        UserMenuNode node = new UserMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UserMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
