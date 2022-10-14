package com.jt.mallservicead.controller;

import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicead.service.AdHomeAdvertiseService;
import com.jt.model.AdHomeAdvertise;
import com.jt.model.AdHomeAdvertiseExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 首页轮播广告管理Controller
 */
@Controller
@Api(tags = "AdHomeAdvertiseController", description = "首页轮播广告管理")
@RequestMapping("/home/advertise")
public class AdHomeAdvertiseController {
    @Autowired
    private AdHomeAdvertiseService advertiseService;

    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody AdHomeAdvertise advertise) {
        int count = advertiseService.create(advertise);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = advertiseService.delete(ids);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, Integer status) {
        int count = advertiseService.updateStatus(id, status);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("获取广告详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AdHomeAdvertise> getItem(@PathVariable Long id) {
        AdHomeAdvertise advertise = advertiseService.getItem(id);
        return CommonResult.success(advertise);
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody AdHomeAdvertise advertise) {
        int count = advertiseService.update(id, advertise);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("分页查询广告")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AdHomeAdvertise>> list(@RequestParam(value = "name", required = false) String name,
                                                          @RequestParam(value = "type", required = false) Integer type,
                                                          @RequestParam(value = "endTime", required = false) String endTime,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AdHomeAdvertise> advertiseList = advertiseService.list(name, type, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(advertiseList));
    }

    @ApiOperation("通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public long countByExample(@RequestBody AdHomeAdvertiseExample example){
        return advertiseService.countByExample(example);
    }

    @ApiOperation("通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody AdHomeAdvertiseExample example){
        return advertiseService.deleteByExample(example);
    }

    @ApiOperation("通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return advertiseService.deleteByPrimaryKey(id);
    }

    @ApiOperation("插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody AdHomeAdvertise record){
        return advertiseService.insert(record);
    }

    @ApiOperation("插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody AdHomeAdvertise record){
        return advertiseService.insertSelective(record);
    }

    @ApiOperation("通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<AdHomeAdvertise> selectByExample(@RequestBody AdHomeAdvertiseExample example){
        return advertiseService.selectByExample(example);
    }

    @ApiOperation("通过主键key查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    AdHomeAdvertise selectByPrimaryKey(@RequestParam("id") Long id){
        return advertiseService.selectByPrimaryKey(id);
    }

    @ApiOperation("更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        AdHomeAdvertise record = (AdHomeAdvertise)map.get("AdHomeAdvertise");
        AdHomeAdvertiseExample example = (AdHomeAdvertiseExample)map.get("AdHomeAdvertiseExample");
        return advertiseService.updateByExampleSelective(record,example);
    }

    @ApiOperation("通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        AdHomeAdvertise record = (AdHomeAdvertise)map.get("AdHomeAdvertise");
        AdHomeAdvertiseExample example = (AdHomeAdvertiseExample)map.get("AdHomeAdvertiseExample");
        return advertiseService.updateByExample(record,example);
    }

    @ApiOperation("更新2")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody AdHomeAdvertise record){
        return advertiseService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("更新3")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody AdHomeAdvertise record){
        return advertiseService.updateByPrimaryKey(record);
    }
}
