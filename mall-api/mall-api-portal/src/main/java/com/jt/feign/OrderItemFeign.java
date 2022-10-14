package com.jt.feign;

import com.jt.model.OrderItem;
import com.jt.model.OrderItemExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface OrderItemFeign {

    @PostMapping(value = "/orderItem/countByExample")
    long countByExample(@RequestBody OrderItemExample example);

    @PostMapping(value = "/orderItem/deleteByExample")
    int deleteByExample(@RequestBody OrderItemExample example);

    @DeleteMapping(value = "/orderItem/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/orderItem/insert")
    int insert(@RequestBody OrderItem record);

    @PostMapping(value = "/orderItem/insertSelective")
    int insertSelective(@RequestBody OrderItem record);

    @PostMapping(value = "/orderItem/selectByExample")
    List<OrderItem> selectByExample(@RequestBody OrderItemExample example);

    @GetMapping(value = "/orderItem/selectByPrimaryKey")
    OrderItem selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/orderItem/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/orderItem/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/orderItem/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody OrderItem record);

    @PostMapping(value = "/orderItem/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody OrderItem record);
}
