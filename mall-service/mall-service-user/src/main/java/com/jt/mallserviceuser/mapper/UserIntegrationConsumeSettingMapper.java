package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserIntegrationConsumeSetting;
import com.jt.model.UserIntegrationConsumeSettingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIntegrationConsumeSettingMapper {
    long countByExample(UserIntegrationConsumeSettingExample example);

    int deleteByExample(UserIntegrationConsumeSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIntegrationConsumeSetting record);

    int insertSelective(UserIntegrationConsumeSetting record);

    List<UserIntegrationConsumeSetting> selectByExample(UserIntegrationConsumeSettingExample example);

    UserIntegrationConsumeSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserIntegrationConsumeSetting record, @Param("example") UserIntegrationConsumeSettingExample example);

    int updateByExample(@Param("record") UserIntegrationConsumeSetting record, @Param("example") UserIntegrationConsumeSettingExample example);

    int updateByPrimaryKeySelective(UserIntegrationConsumeSetting record);

    int updateByPrimaryKey(UserIntegrationConsumeSetting record);
}