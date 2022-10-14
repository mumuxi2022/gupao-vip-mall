package com.jt.mallservicegoods.controller;

import com.jt.mallservicegoods.service.GoodsProductLadderService;
import com.jt.model.GoodsProductLadder;
import com.jt.model.GoodsProductLadderExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 产品阶梯价格Controller
 */
@Controller
@Api(tags = "GoodsProductLadderController", description = "产品阶梯价格管理")
@RequestMapping("/productLadder")
public class GoodsProductLadderController {
    @Autowired
    private GoodsProductLadderService productLadderService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody GoodsProductLadderExample userMemberExample) {
        return productLadderService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsProductLadderExample example){
        return productLadderService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return productLadderService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsProductLadder record){
        return productLadderService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsProductLadder record){
        return productLadderService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProductLadder> selectByExample(@RequestBody GoodsProductLadderExample example){
        return productLadderService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsProductLadder selectByPrimaryKey(@RequestParam("id") Long id){
        return productLadderService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsProductLadder record = (GoodsProductLadder)map.get("GoodsProductLadder");
        GoodsProductLadderExample example = (GoodsProductLadderExample)map.get("GoodsProductLadderExample");
        return productLadderService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsProductLadder record = (GoodsProductLadder)map.get("GoodsProductLadder");
        GoodsProductLadderExample example = (GoodsProductLadderExample)map.get("GoodsProductLadderExample");
        return productLadderService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsProductLadder record){
        return productLadderService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsProductLadder record){
        return productLadderService.updateByPrimaryKey(record);
    }
}
