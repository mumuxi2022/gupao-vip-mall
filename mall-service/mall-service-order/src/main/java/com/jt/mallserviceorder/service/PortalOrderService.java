package com.jt.mallserviceorder.service;

import com.jt.model.OrderInfoDetail;

import java.util.List;

public interface PortalOrderService {
    /**
     * 获取订单及下单商品详情
     */
    OrderInfoDetail getDetail(Long orderId);

    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    List<OrderInfoDetail> getTimeOutOrders(Integer minute);

    /**
     * 批量修改订单状态
     */
    int updateOrderStatus(List<Long> ids,Integer status);


}
