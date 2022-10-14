package com.jt.mallserviceuser.controller;

import com.jt.mallserviceuser.service.UserMemberReceiveAddressService;
import com.jt.mallserviceuser.service.UserMemberService;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 10:15
 * 收货地址管理
 */
@RestController
@Api(tags = "UserMemberReceiveAddressController", description = "收货地址管理")
@RequestMapping("/memberReceiveAddress")
public class UserMemberReceiveAddressController {
    @Autowired
    private UserMemberReceiveAddressService adminService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody UserMemberReceiveAddressExample userMemberExample) {
        return adminService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody UserMemberReceiveAddressExample example){
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
    int insert(@RequestBody UserMemberReceiveAddress record){
        return adminService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody UserMemberReceiveAddress record){
        return adminService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<UserMemberReceiveAddress> selectByExample(@RequestBody UserMemberReceiveAddressExample example){
        return adminService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    UserMemberReceiveAddress selectByPrimaryKey(@RequestParam("id") Long id){
        return adminService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByExampleSelective(@RequestBody Map<String,Object> map){
        UserMemberReceiveAddress record = (UserMemberReceiveAddress)map.get("UserMemberReceiveAddress");
        UserMemberReceiveAddressExample example = (UserMemberReceiveAddressExample)map.get("UserMemberReceiveAddressExample");
        return adminService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestBody Map<String,Object> map){
        UserMemberReceiveAddress record = (UserMemberReceiveAddress)map.get("UserMemberReceiveAddress");
        UserMemberReceiveAddressExample example = (UserMemberReceiveAddressExample)map.get("UserMemberReceiveAddressExample");
        return adminService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody UserMemberReceiveAddress record){
        return adminService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody UserMemberReceiveAddress record){
        return adminService.updateByPrimaryKey(record);
    }
}

