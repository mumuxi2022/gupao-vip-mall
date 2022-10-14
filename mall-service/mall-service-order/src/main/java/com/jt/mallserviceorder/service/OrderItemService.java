package com.jt.mallserviceorder.service;

import com.jt.model.OrderItem;
import com.jt.model.OrderItemExample;

import java.util.List;


public interface OrderItemService {

    int insertList(List<OrderItem> list);

    long countByExample(OrderItemExample example);

    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(OrderItem record, OrderItemExample example);

    int updateByExample(OrderItem record,OrderItemExample example);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
