package com.jt.mallserviceorder.service.impl;

import com.jt.mallserviceorder.mapper.PortalOrderMapper;
import com.jt.mallserviceorder.service.PortalOrderService;
import com.jt.model.OrderInfoDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalOrderServiceImpl implements PortalOrderService {
    @Autowired
    private PortalOrderMapper orderMapper;

    @Override
    public OrderInfoDetail getDetail(Long orderId) {
        return orderMapper.getDetail(orderId);
    }

    @Override
    public List<OrderInfoDetail> getTimeOutOrders(Integer minute) {
        return orderMapper.getTimeOutOrders(minute);
    }

    @Override
    public int updateOrderStatus(List<Long> ids, Integer status) {
        return orderMapper.updateOrderStatus(ids,status);
    }

}
