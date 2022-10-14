package com.jt.feign;

import com.jt.model.UserIntegrationConsumeSetting;
import com.jt.model.UserIntegrationConsumeSettingExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-user")
public interface UserIntegrationConsumeSettingFeign {

    @PostMapping(value = "/integrationConsumeSetting/countByExample")
    long countByExample(@RequestBody UserIntegrationConsumeSettingExample example);

    @PostMapping(value = "/integrationConsumeSetting/deleteByExample")
    int deleteByExample(@RequestBody UserIntegrationConsumeSettingExample example);

    @DeleteMapping(value = "/integrationConsumeSetting/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/integrationConsumeSetting/insert")
    int insert(@RequestBody UserIntegrationConsumeSetting record);

    @PostMapping(value = "/integrationConsumeSetting/insertSelective")
    int insertSelective(@RequestBody UserIntegrationConsumeSetting record);

    @PostMapping(value = "/integrationConsumeSetting/selectByExample")
    List<UserIntegrationConsumeSetting> selectByExample(@RequestBody UserIntegrationConsumeSettingExample example);

    @GetMapping(value = "/integrationConsumeSetting/selectByPrimaryKey")
    UserIntegrationConsumeSetting selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/integrationConsumeSetting/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/integrationConsumeSetting/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/integrationConsumeSetting/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UserIntegrationConsumeSetting record);

    @PostMapping(value = "/integrationConsumeSetting/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UserIntegrationConsumeSetting record);

}
