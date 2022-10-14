package com.jt.mallserviceuser.service.impl;

import com.jt.mallserviceuser.mapper.UserIntegrationConsumeSettingMapper;
import com.jt.mallserviceuser.service.UserIntegrationConsumeSettingService;
import com.jt.model.UserIntegrationConsumeSetting;
import com.jt.model.UserIntegrationConsumeSettingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:06
 * 积分消费管理Service实现类
 */
@Service
public class UserIntegrationConsumeSettingServiceImpl implements UserIntegrationConsumeSettingService {
    @Autowired
    private UserIntegrationConsumeSettingMapper userIntegrationConsumeSettingMapper;

    @Override
    public long countByExample(UserIntegrationConsumeSettingExample example) {
        return userIntegrationConsumeSettingMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserIntegrationConsumeSettingExample example) {
        return userIntegrationConsumeSettingMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userIntegrationConsumeSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserIntegrationConsumeSetting record) {
        return userIntegrationConsumeSettingMapper.insert(record);
    }

    @Override
    public int insertSelective(UserIntegrationConsumeSetting record) {
        return userIntegrationConsumeSettingMapper.insertSelective(record);
    }

    @Override
    public List<UserIntegrationConsumeSetting> selectByExample(UserIntegrationConsumeSettingExample example) {
        return userIntegrationConsumeSettingMapper.selectByExample(example);
    }

    @Override
    public UserIntegrationConsumeSetting selectByPrimaryKey(Long id) {
        return userIntegrationConsumeSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserIntegrationConsumeSetting record, UserIntegrationConsumeSettingExample example) {
        return userIntegrationConsumeSettingMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserIntegrationConsumeSetting record, UserIntegrationConsumeSettingExample example) {
        return userIntegrationConsumeSettingMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserIntegrationConsumeSetting record) {
        return userIntegrationConsumeSettingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserIntegrationConsumeSetting record) {
        return userIntegrationConsumeSettingMapper.updateByPrimaryKey(record);
    }
}
