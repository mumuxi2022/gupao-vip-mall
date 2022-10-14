package com.jt.dto;

import com.jt.model.OrderInfo;
import com.jt.model.OrderItem;
import com.jt.model.OrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 */
public class OrderDetail extends OrderInfo {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OrderOperateHistory> historyList;
}
