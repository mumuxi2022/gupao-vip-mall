package com.jt.mallserviceorder.mapper;

import com.jt.model.OrderSetting;
import com.jt.model.OrderSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSettingMapper {
    long countByExample(OrderSettingExample example);

    int deleteByExample(OrderSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSetting record);

    int insertSelective(OrderSetting record);

    List<OrderSetting> selectByExample(OrderSettingExample example);

    OrderSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderSetting record, @Param("example") OrderSettingExample example);

    int updateByExample(@Param("record") OrderSetting record, @Param("example") OrderSettingExample example);

    int updateByPrimaryKeySelective(OrderSetting record);

    int updateByPrimaryKey(OrderSetting record);
}