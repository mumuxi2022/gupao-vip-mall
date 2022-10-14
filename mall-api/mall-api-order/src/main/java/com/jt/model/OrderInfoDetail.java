package com.jt.model;

import java.util.List;

/**
 * 包含商品信息的订单详情
 */
public class OrderInfoDetail extends OrderInfo {
    //订单商品列表
    private List<OrderItem> orderItemList;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
