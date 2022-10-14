package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberRuleSetting;
import com.jt.model.UserMemberRuleSettingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberRuleSettingMapper {
    long countByExample(UserMemberRuleSettingExample example);

    int deleteByExample(UserMemberRuleSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberRuleSetting record);

    int insertSelective(UserMemberRuleSetting record);

    List<UserMemberRuleSetting> selectByExample(UserMemberRuleSettingExample example);

    UserMemberRuleSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberRuleSetting record, @Param("example") UserMemberRuleSettingExample example);

    int updateByExample(@Param("record") UserMemberRuleSetting record, @Param("example") UserMemberRuleSettingExample example);

    int updateByPrimaryKeySelective(UserMemberRuleSetting record);

    int updateByPrimaryKey(UserMemberRuleSetting record);
}