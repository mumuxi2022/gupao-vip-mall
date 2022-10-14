package com.jt.mallserviceorder.controller;

import com.jt.mallserviceorder.service.PortalOrderService;
import com.jt.model.OrderInfoDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 前台系统管理订单Controller
 */
@Controller
@Api(tags = "PortalOrderController", description = "前台系统管理订单")
@RequestMapping("/portalOrder")
public class PortalOrderController {
    @Autowired
    private PortalOrderService portalOrderService;

    /**
     * 获取订单及下单商品详情
     */
    @ApiOperation(value = "获取详情")
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    @ResponseBody
    public OrderInfoDetail getDetail(@RequestParam("orderId") Long orderId){
        return portalOrderService.getDetail(orderId);
    }



    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    @ApiOperation(value = "查询超时订单")
    @RequestMapping(value = "/getTimeOutOrders", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderInfoDetail> getTimeOutOrders(@RequestParam("minute") Integer minute){
        return portalOrderService.getTimeOutOrders(minute);
    }

    /**
     * 批量修改订单状态
     */
    @ApiOperation(value = "批量修改订单状态")
    @RequestMapping(value = "/updateOrderStatus", method = RequestMethod.PUT)
    @ResponseBody
    public int updateOrderStatus(@RequestParam("ids") List<Long> ids,@RequestParam("status") Integer status){
        return portalOrderService.updateOrderStatus(ids,status);
    }



}
