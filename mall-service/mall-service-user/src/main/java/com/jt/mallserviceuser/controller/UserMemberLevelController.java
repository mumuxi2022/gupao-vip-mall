package com.jt.mallserviceuser.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallserviceuser.service.UserMemberLevelService;
import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:03
 * 会员等级管理Controller
 */
@Controller
@Api(tags = "UserMemberLevelController", description = "会员等级管理")
@RequestMapping("/memberLevel")
public class UserMemberLevelController {
    @Autowired
    private UserMemberLevelService memberLevelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation("查询所有会员等级")
    @ResponseBody
    public CommonResult<List<UserMemberLevel>> list(@RequestParam("defaultStatus") Integer defaultStatus) {
        List<UserMemberLevel> memberLevelList = memberLevelService.list(defaultStatus);
        return CommonResult.success(memberLevelList);
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody UserMemberLevelExample userMemberLevelExample) {
        return memberLevelService.countByExample(userMemberLevelExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody UserMemberLevelExample example){
        return memberLevelService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return memberLevelService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody UserMemberLevel record){
        return memberLevelService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody UserMemberLevel record){
        return memberLevelService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<UserMemberLevel> selectByExample(@RequestBody UserMemberLevelExample example){
        return memberLevelService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    UserMemberLevel selectByPrimaryKey(@RequestParam("id") Long id){
        return memberLevelService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        UserMemberLevel record = (UserMemberLevel)map.get("UserMemberLevel");
        UserMemberLevelExample example = (UserMemberLevelExample)map.get("UserMemberLevelExample");
        return memberLevelService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        UserMemberLevel record = (UserMemberLevel)map.get("UserMemberLevel");
        UserMemberLevelExample example = (UserMemberLevelExample)map.get("UserMemberLevelExample");
        return memberLevelService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody UserMemberLevel record){
        return memberLevelService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody UserMemberLevel record){
        return memberLevelService.updateByPrimaryKey(record);
    }
}
