package com.jt.mallserviceorder.service;


import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;

import java.util.List;

public interface OrderCartItemService {
    long countByExample(OrderCartItemExample example);

    int deleteByExample(OrderCartItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCartItem record);

    int insertSelective(OrderCartItem record);

    List<OrderCartItem> selectByExample(OrderCartItemExample example);

    OrderCartItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(OrderCartItem record, OrderCartItemExample example);

    int updateByExample(OrderCartItem record,OrderCartItemExample example);

    int updateByPrimaryKeySelective(OrderCartItem record);

    int updateByPrimaryKey(OrderCartItem record);
}
