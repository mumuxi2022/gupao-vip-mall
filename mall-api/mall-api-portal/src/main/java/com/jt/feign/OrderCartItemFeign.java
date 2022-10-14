package com.jt.feign;

import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface OrderCartItemFeign {

    @PostMapping(value = "/orderCartItem/countByExample")
    long countByExample(@RequestBody OrderCartItemExample example);

    @PostMapping(value = "/orderCartItem/deleteByExample")
    int deleteByExample(@RequestBody OrderCartItemExample example);

    @DeleteMapping(value = "/orderCartItem/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/orderCartItem/insert")
    int insert(@RequestBody OrderCartItem record);

    @PostMapping(value = "/orderCartItem/insertSelective")
    int insertSelective(@RequestBody OrderCartItem record);

    @PostMapping(value = "/orderCartItem/selectByExample")
    List<OrderCartItem> selectByExample(@RequestBody OrderCartItemExample example);

    @GetMapping(value = "/orderCartItem/selectByPrimaryKey")
    OrderCartItem selectByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/orderCartItem/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/orderCartItem/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/orderCartItem/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody OrderCartItem record);

    @PostMapping(value = "/orderCartItem/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody OrderCartItem record);
}
