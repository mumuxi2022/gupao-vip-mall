package com.jt.mallserviceorder.controller;

import com.jt.mallserviceorder.service.OrderItemService;
import com.jt.model.OrderItem;
import com.jt.model.OrderItemExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 订单中所包含的商品Controller
 */
@Controller
@Api(tags = "OrderItemController", description = "订单中所包含的商品管理")
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderService;

    @ApiOperation("插入")
    @RequestMapping(value = "/insertList", method = RequestMethod.POST)
    @ResponseBody
    int insertList(@RequestBody List<OrderItem> list){
        return orderService.insertList(list);
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody OrderItemExample userMemberExample) {
        return orderService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody OrderItemExample example){
        return orderService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return orderService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody OrderItem record){
        return orderService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody OrderItem record){
        return orderService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<OrderItem> selectByExample(@RequestBody OrderItemExample example){
        return orderService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    OrderItem selectByPrimaryKey(@RequestParam("id") Long id){
        return orderService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestBody Map<String,Object> map){
        OrderItem record = (OrderItem)map.get("OrderItem");
        OrderItemExample example = (OrderItemExample)map.get("OrderItemExample");
        return orderService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestBody Map<String,Object> map){
        OrderItem record = (OrderItem)map.get("OrderItem");
        OrderItemExample example = (OrderItemExample)map.get("OrderItemExample");
        return orderService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody OrderItem record){
        return orderService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody OrderItem record){
        return orderService.updateByPrimaryKey(record);
    }
}
