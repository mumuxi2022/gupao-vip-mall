package com.jt.mallserviceorder.service.impl;

import com.jt.mallserviceorder.mapper.OrderSettingMapper;
import com.jt.mallserviceorder.service.OrderSettingService;
import com.jt.model.OrderSetting;
import com.jt.model.OrderSettingExample;
import com.jt.model.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单设置管理Service实现类
 */
@Service
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Override
    public OrderSetting getItem(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, OrderSetting orderSetting) {
        orderSetting.setId(id);
        return orderSettingMapper.updateByPrimaryKey(orderSetting);
    }

    @Override
    public long countByExample(OrderSettingExample example) {
        return orderSettingMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderSettingExample example) {
        return orderSettingMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderSetting record) {
        return orderSettingMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderSetting record) {
        return orderSettingMapper.insertSelective(record);
    }

    @Override
    public List<OrderSetting> selectByExample(OrderSettingExample example) {
        return orderSettingMapper.selectByExample(example);
    }

    @Override
    public OrderSetting selectByPrimaryKey(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderSetting record, OrderSettingExample example) {
        return orderSettingMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderSetting record, OrderSettingExample example) {
        return orderSettingMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderSetting record) {
        return orderSettingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderSetting record) {
        return orderSettingMapper.updateByPrimaryKey(record);
    }
}
