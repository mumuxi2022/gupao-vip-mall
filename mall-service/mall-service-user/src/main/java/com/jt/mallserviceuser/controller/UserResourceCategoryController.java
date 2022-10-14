package com.jt.mallserviceuser.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallserviceuser.service.UserResourceCategoryService;
import com.jt.model.UserResourceCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/16 18:08
 * 后台资源分类管理Controller
 */
@Controller
@Api(tags = "UserResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UserResourceCategoryController {
    @Autowired
    private UserResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserResourceCategory>> listAll() {
        List<UserResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UserResourceCategory UserResourceCategory) {
        int count = resourceCategoryService.create(UserResourceCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UserResourceCategory UserResourceCategory) {
        int count = resourceCategoryService.update(id, UserResourceCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = resourceCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
