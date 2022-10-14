package com.jt.mallservicegoods.controller;

import com.jt.mallservicegoods.service.GoodsProductFullReductionService;
import com.jt.model.GoodsProductFullReduction;
import com.jt.model.GoodsProductFullReductionExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 产品满减Controller
 */
@Controller
@Api(tags = "GoodsProductFullReductionController", description = "产品满减管理")
@RequestMapping("/productFullReduction")
public class GoodsProductFullReductionController {
    @Autowired
    private GoodsProductFullReductionService productFullReductionService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody GoodsProductFullReductionExample userMemberExample) {
        return productFullReductionService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsProductFullReductionExample example){
        return productFullReductionService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return productFullReductionService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsProductFullReduction record){
        return productFullReductionService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsProductFullReduction record){
        return productFullReductionService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProductFullReduction> selectByExample(@RequestBody GoodsProductFullReductionExample example){
        return productFullReductionService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsProductFullReduction selectByPrimaryKey(@RequestParam("id") Long id){
        return productFullReductionService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsProductFullReduction record = (GoodsProductFullReduction)map.get("GoodsProductFullReduction");
        GoodsProductFullReductionExample example = (GoodsProductFullReductionExample)map.get("GoodsProductFullReductionExample");
        return productFullReductionService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsProductFullReduction record = (GoodsProductFullReduction)map.get("GoodsProductFullReduction");
        GoodsProductFullReductionExample example = (GoodsProductFullReductionExample)map.get("GoodsProductFullReductionExample");
        return productFullReductionService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsProductFullReduction record){
        return productFullReductionService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsProductFullReduction record){
        return productFullReductionService.updateByPrimaryKey(record);
    }
}
