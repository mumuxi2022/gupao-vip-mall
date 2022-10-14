package com.jt.feign;

import com.jt.model.OrderSetting;
import com.jt.model.OrderSettingExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface OrderSettingFeign {

    @PostMapping(value = "/orderSetting/countByExample")
    long countByExample(@RequestBody OrderSettingExample example);

    @PostMapping(value = "/orderSetting/deleteByExample")
    int deleteByExample(@RequestBody OrderSettingExample example);

    @DeleteMapping(value = "/orderSetting/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/orderSetting/insert")
    int insert(@RequestBody OrderSetting record);

    @PostMapping(value = "/orderSetting/insertSelective")
    int insertSelective(@RequestBody OrderSetting record);

    @PostMapping(value = "/orderSetting/selectByExample")
    List<OrderSetting> selectByExample(@RequestBody OrderSettingExample example);

    @GetMapping(value = "/orderSetting/selectByPrimaryKey")
    OrderSetting selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/orderSetting/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/orderSetting/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/orderSetting/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody OrderSetting record);

    @PostMapping(value = "/orderSetting/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody OrderSetting record);
}
