package com.jt.feign;

import com.jt.model.OrderReturnApply;
import com.jt.model.OrderReturnApplyExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface OrderReturnApplyFeign {

    @PostMapping(value = "/returnApply/countByExample")
    long countByExample(@RequestBody OrderReturnApplyExample example);

    @PostMapping(value = "/returnApply/deleteByExample")
    int deleteByExample(@RequestBody OrderReturnApplyExample example);

    @DeleteMapping(value = "/returnApply/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/returnApply/insert")
    int insert(@RequestBody OrderReturnApply record);

    @PostMapping(value = "/returnApply/insertSelective")
    int insertSelective(@RequestBody OrderReturnApply record);

    @PostMapping(value = "/returnApply/selectByExample")
    List<OrderReturnApply> selectByExample(@RequestBody OrderReturnApplyExample example);

    @GetMapping(value = "/returnApply/selectByPrimaryKey")
    OrderReturnApply selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/returnApply/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/returnApply/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/returnApply/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody OrderReturnApply record);

    @PostMapping(value = "/returnApply/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody OrderReturnApply record);

}
