package com.jt.feign;

import com.jt.model.OrderInfoDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface PortalOrderFeign {

    /**
     * 获取订单及下单商品详情
     */
    @GetMapping(value = "/portalOrder/getDetail")
    OrderInfoDetail getDetail(@RequestParam("orderId") Long orderId);



    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    @GetMapping(value = "/portalOrder/getTimeOutOrders")
    List<OrderInfoDetail> getTimeOutOrders(@RequestParam("minute") Integer minute);

    /**
     * 批量修改订单状态
     */
    @PutMapping(value = "/portalOrder/updateOrderStatus")
    int updateOrderStatus(@RequestParam("ids") List<Long> ids,@RequestParam("status") Integer status);


}
