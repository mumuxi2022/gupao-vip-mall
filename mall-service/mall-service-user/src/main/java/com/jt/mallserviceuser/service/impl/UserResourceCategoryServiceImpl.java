package com.jt.mallserviceuser.service.impl;

import com.jt.mallserviceuser.mapper.UserResourceCategoryMapper;
import com.jt.mallserviceuser.service.UserResourceCategoryService;
import com.jt.model.UserResourceCategory;
import com.jt.model.UserResourceCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:11
 * 后台资源分类管理Service实现类
 */
@Service
public class UserResourceCategoryServiceImpl implements UserResourceCategoryService {
    @Autowired
    private UserResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UserResourceCategory> listAll() {
        UserResourceCategoryExample example = new UserResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(UserResourceCategory UserResourceCategory) {
        UserResourceCategory.setCreateTime(new Date());
        return resourceCategoryMapper.insert(UserResourceCategory);
    }

    @Override
    public int update(Long id, UserResourceCategory UserResourceCategory) {
        UserResourceCategory.setId(id);
        return resourceCategoryMapper.updateByPrimaryKeySelective(UserResourceCategory);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }
}
