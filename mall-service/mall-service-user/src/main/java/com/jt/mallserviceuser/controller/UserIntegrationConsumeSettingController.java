package com.jt.mallserviceuser.controller;

import com.jt.mallserviceuser.service.UserIntegrationConsumeSettingService;
import com.jt.model.UserIntegrationConsumeSetting;
import com.jt.model.UserIntegrationConsumeSettingExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 10:15
 * 积分消费管理
 */
@RestController
@Api(tags = "UserIntegrationConsumeSettingController", description = "积分消费")
@RequestMapping("/integrationConsumeSetting")
public class UserIntegrationConsumeSettingController {
    @Autowired
    private UserIntegrationConsumeSettingService adminService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody UserIntegrationConsumeSettingExample userMemberExample) {
        return adminService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody UserIntegrationConsumeSettingExample example){
        return adminService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return adminService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody UserIntegrationConsumeSetting record){
        return adminService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody UserIntegrationConsumeSetting record){
        return adminService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<UserIntegrationConsumeSetting> selectByExample(@RequestBody UserIntegrationConsumeSettingExample example){
        return adminService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    UserIntegrationConsumeSetting selectByPrimaryKey(@RequestParam("id") Long id){
        return adminService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        UserIntegrationConsumeSetting record = (UserIntegrationConsumeSetting)map.get("UserIntegrationConsumeSetting");
        UserIntegrationConsumeSettingExample example = (UserIntegrationConsumeSettingExample)map.get("UserIntegrationConsumeSettingExample");
        return adminService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        UserIntegrationConsumeSetting record = (UserIntegrationConsumeSetting)map.get("UserIntegrationConsumeSetting");
        UserIntegrationConsumeSettingExample example = (UserIntegrationConsumeSettingExample)map.get("UserIntegrationConsumeSettingExample");
        return adminService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody UserIntegrationConsumeSetting record){
        return adminService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody UserIntegrationConsumeSetting record){
        return adminService.updateByPrimaryKey(record);
    }
}

