package com.jt.mallserviceorder.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallserviceorder.service.OrderCartItemService;
import com.jt.mallserviceorder.service.OrderSettingService;
import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;
import com.jt.model.OrderSetting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 购物车管理Controller
 */
@Controller
@Api(tags = "OrderCartItemController", description = "购物车管理")
@RequestMapping("/orderCartItem")
public class OrderCartItemController {
    @Autowired
    private OrderCartItemService orderCartItemService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody OrderCartItemExample orderCartItemExample) {
        return orderCartItemService.countByExample(orderCartItemExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody OrderCartItemExample example){
        return orderCartItemService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return orderCartItemService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody OrderCartItem record){
        return orderCartItemService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody OrderCartItem record){
        return orderCartItemService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<OrderCartItem> selectByExample(@RequestBody OrderCartItemExample example){
        return orderCartItemService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    OrderCartItem selectByPrimaryKey(@RequestParam("id") Long id){
        return orderCartItemService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByExampleSelective(@RequestBody Map<String,Object> map){
        OrderCartItem record = (OrderCartItem)map.get("OrderCartItem");
        OrderCartItemExample example = (OrderCartItemExample)map.get("OrderCartItemExample");
        return orderCartItemService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        OrderCartItem record = (OrderCartItem)map.get("OrderCartItem");
        OrderCartItemExample example = (OrderCartItemExample)map.get("OrderCartItemExample");
        return orderCartItemService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody OrderCartItem record){
        return orderCartItemService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody OrderCartItem record){
        return orderCartItemService.updateByPrimaryKey(record);
    }

}
