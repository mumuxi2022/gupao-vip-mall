package com.jt.mallserviceuser.controller;

import cn.hutool.core.collection.CollUtil;
import com.jt.dto.UpdateAdminPasswordParam;
import com.jt.dto.UserAdminLoginParam;
import com.jt.dto.UserAdminParam;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallcommon.domain.UserDto;
import com.jt.mallserviceuser.service.UserMemberService;
import com.jt.model.UserAdmin;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import com.jt.model.UserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 10:15
 * 后台用户管理
 */
@RestController
@Api(tags = "UserMemberController", description = "会员管理")
@RequestMapping("/member")
public class UserMemberController {
    @Autowired
    private UserMemberService adminService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody UserMemberExample userMemberExample) {
        return adminService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody UserMemberExample example){
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
    int insert(@RequestBody UserMember record){
        return adminService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody UserMember record){
        return adminService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<UserMember> selectByExample(@RequestBody UserMemberExample example){
        return adminService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    UserMember selectByPrimaryKey(@RequestParam("id") Long id){
        return adminService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        UserMember record = (UserMember)map.get("UserMember");
        UserMemberExample example = (UserMemberExample)map.get("UserMemberExample");
        return adminService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        UserMember record = (UserMember)map.get("UserMember");
        UserMemberExample example = (UserMemberExample)map.get("UserMemberExample");
        return adminService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody UserMember record){
        return adminService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody UserMember record){
        return adminService.updateByPrimaryKey(record);
    }
}

