package com.jt.mallserviceorder.mapper;

import com.jt.dto.OrderDetail;
import com.jt.model.OrderInfoDetail;
import com.jt.model.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前台订单自定义Dao
 */
@Repository
public interface PortalOrderMapper {
    /**
     * 获取订单及下单商品详情
     */
    OrderInfoDetail getDetail(@Param("orderId") Long orderId);

    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    List<OrderInfoDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * 批量修改订单状态
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);


}
