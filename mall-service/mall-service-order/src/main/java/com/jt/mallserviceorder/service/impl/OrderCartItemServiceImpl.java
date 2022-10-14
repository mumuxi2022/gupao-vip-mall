package com.jt.mallserviceorder.service.impl;

import com.jt.mallserviceorder.mapper.OrderCartItemMapper;
import com.jt.mallserviceorder.service.OrderCartItemService;
import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderCartItemServiceImpl implements OrderCartItemService {
    @Autowired
    private OrderCartItemMapper orderCartItemMapper;


    @Override
    public long countByExample(OrderCartItemExample example) {
        return orderCartItemMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderCartItemExample example) {
        return orderCartItemMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderCartItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderCartItem record) {
        return orderCartItemMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderCartItem record) {
        return orderCartItemMapper.insertSelective(record);
    }

    @Override
    public List<OrderCartItem> selectByExample(OrderCartItemExample example) {
        return orderCartItemMapper.selectByExample(example);
    }

    @Override
    public OrderCartItem selectByPrimaryKey(Long id) {
        return orderCartItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderCartItem record, OrderCartItemExample example) {
        return orderCartItemMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderCartItem record, OrderCartItemExample example) {
        return orderCartItemMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderCartItem record) {
        return orderCartItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderCartItem record) {
        return orderCartItemMapper.updateByPrimaryKey(record);
    }
}
