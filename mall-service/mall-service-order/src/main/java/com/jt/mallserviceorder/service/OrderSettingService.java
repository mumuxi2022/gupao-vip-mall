package com.jt.mallserviceorder.service;


import com.jt.model.OrderSetting;
import com.jt.model.OrderSettingExample;

import java.util.List;

/**
 * 订单设置Service
 */
public interface OrderSettingService {
    /**
     * 获取指定订单设置
     */
    OrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OrderSetting orderSetting);

    long countByExample(OrderSettingExample example);

    int deleteByExample(OrderSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSetting record);

    int insertSelective(OrderSetting record);

    List<OrderSetting> selectByExample(OrderSettingExample example);

    OrderSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(OrderSetting record, OrderSettingExample example);

    int updateByExample(OrderSetting record,OrderSettingExample example);

    int updateByPrimaryKeySelective(OrderSetting record);

    int updateByPrimaryKey(OrderSetting record);
}
