package com.jt.mallserviceuser.mapper;

import com.jt.model.UserResourceCategory;
import com.jt.model.UserResourceCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:14
 */
public interface UserResourceCategoryMapper {
    long countByExample(UserResourceCategoryExample example);

    int deleteByExample(UserResourceCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserResourceCategory record);

    int insertSelective(UserResourceCategory record);

    List<UserResourceCategory> selectByExample(UserResourceCategoryExample example);

    UserResourceCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserResourceCategory record, @Param("example") UserResourceCategoryExample example);

    int updateByExample(@Param("record") UserResourceCategory record, @Param("example") UserResourceCategoryExample example);

    int updateByPrimaryKeySelective(UserResourceCategory record);

    int updateByPrimaryKey(UserResourceCategory record);
}
