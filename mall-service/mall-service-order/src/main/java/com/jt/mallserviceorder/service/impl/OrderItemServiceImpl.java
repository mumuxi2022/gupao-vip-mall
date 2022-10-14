package com.jt.mallserviceorder.service.impl;

import com.jt.mallserviceorder.mapper.OrderItemMapper;
import com.jt.mallserviceorder.service.OrderItemService;
import com.jt.model.OrderItem;
import com.jt.model.OrderItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderMapper;

    @Override
    public int insertList(List<OrderItem> list){
        return orderMapper.insertList(list);
    }

    @Override
    public long countByExample(OrderItemExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderItemExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderItem record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderItem record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public List<OrderItem> selectByExample(OrderItemExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public OrderItem selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderItem record, OrderItemExample example) {
        return orderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderItem record, OrderItemExample example) {
        return orderMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderMapper.updateByPrimaryKey(record);
    }
}
