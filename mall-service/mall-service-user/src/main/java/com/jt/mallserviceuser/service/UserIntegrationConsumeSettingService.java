package com.jt.mallserviceuser.service;

import com.jt.model.UserIntegrationConsumeSetting;
import com.jt.model.UserIntegrationConsumeSettingExample;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:03
 * 积分消费管理Service
 */
public interface UserIntegrationConsumeSettingService {
    long countByExample(UserIntegrationConsumeSettingExample example);

    int deleteByExample(UserIntegrationConsumeSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIntegrationConsumeSetting record);

    int insertSelective(UserIntegrationConsumeSetting record);

    List<UserIntegrationConsumeSetting> selectByExample(UserIntegrationConsumeSettingExample example);

    UserIntegrationConsumeSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserIntegrationConsumeSetting record, UserIntegrationConsumeSettingExample example);

    int updateByExample(UserIntegrationConsumeSetting record,UserIntegrationConsumeSettingExample example);

    int updateByPrimaryKeySelective(UserIntegrationConsumeSetting record);

    int updateByPrimaryKey(UserIntegrationConsumeSetting record);
}
