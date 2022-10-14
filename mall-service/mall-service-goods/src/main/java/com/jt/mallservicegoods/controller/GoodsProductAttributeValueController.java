package com.jt.mallservicegoods.controller;

import com.jt.mallservicegoods.service.GoodsProductAttributeValueService;
import com.jt.model.GoodsProductAttributeValue;
import com.jt.model.GoodsProductAttributeValueExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品属性管理Controller
 */
@Controller
@Api(tags = "GoodsProductAttributeValueController", description = "产品参数信息管理")
@RequestMapping("/productAttributeValue")
public class GoodsProductAttributeValueController {
    @Autowired
    private GoodsProductAttributeValueService productAttributeValueService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody GoodsProductAttributeValueExample userMemberExample) {
        return productAttributeValueService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsProductAttributeValueExample example){
        return productAttributeValueService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return productAttributeValueService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsProductAttributeValue record){
        return productAttributeValueService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsProductAttributeValue record){
        return productAttributeValueService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProductAttributeValue> selectByExample(@RequestBody GoodsProductAttributeValueExample example){
        return productAttributeValueService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsProductAttributeValue selectByPrimaryKey(@RequestParam("id") Long id){
        return productAttributeValueService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsProductAttributeValue record = (GoodsProductAttributeValue)map.get("GoodsProductAttributeValue");
        GoodsProductAttributeValueExample example = (GoodsProductAttributeValueExample)map.get("GoodsProductAttributeValueExample");
        return productAttributeValueService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsProductAttributeValue record = (GoodsProductAttributeValue)map.get("GoodsProductAttributeValue");
        GoodsProductAttributeValueExample example = (GoodsProductAttributeValueExample)map.get("GoodsProductAttributeValueExample");
        return productAttributeValueService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsProductAttributeValue record){
        return productAttributeValueService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsProductAttributeValue record){
        return productAttributeValueService.updateByPrimaryKey(record);
    }
}
