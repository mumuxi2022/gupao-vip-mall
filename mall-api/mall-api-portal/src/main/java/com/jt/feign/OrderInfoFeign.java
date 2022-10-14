package com.jt.feign;

import com.jt.model.OrderInfo;
import com.jt.model.OrderInfoExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface OrderInfoFeign {

    @PostMapping(value = "/order/countByExample")
    long countByExample(@RequestBody OrderInfoExample example);

    @PostMapping(value = "/order/deleteByExample")
    int deleteByExample(@RequestBody OrderInfoExample example);

    @DeleteMapping(value = "/order/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/order/insert")
    int insert(@RequestBody OrderInfo record);

    @PostMapping(value = "/order/insertSelective")
    int insertSelective(@RequestBody OrderInfo record);

    @PostMapping(value = "/order/selectByExample")
    List<OrderInfo> selectByExample(@RequestBody OrderInfoExample example);

    @GetMapping(value = "/order/selectByPrimaryKey")
    OrderInfo selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/order/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/order/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/order/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody OrderInfo record);

    @PostMapping(value = "/order/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody OrderInfo record);
}
