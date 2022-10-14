package com.jt.feign;

import com.jt.model.AdHomeAdvertise;
import com.jt.model.AdHomeAdvertiseExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdHomeAdvertiseFeign {

    @PostMapping(value = "/home/advertise/countByExample")
    long countByExample(@RequestBody AdHomeAdvertiseExample example);

    @PostMapping(value = "/home/advertise/deleteByExample")
    int deleteByExample(@RequestBody AdHomeAdvertiseExample example);

    @DeleteMapping(value = "/home/advertise/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/home/advertise/insert")
    int insert(@RequestBody AdHomeAdvertise record);

    @PostMapping(value = "/home/advertise/insertSelective")
    int insertSelective(@RequestBody AdHomeAdvertise record);

    @PostMapping(value = "/home/advertise/selectByExample")
    List<AdHomeAdvertise> selectByExample(@RequestBody AdHomeAdvertiseExample example);

    @GetMapping(value = "/home/advertise/selectByPrimaryKey")
    AdHomeAdvertise selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/home/advertise/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/home/advertise/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/home/advertise/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody AdHomeAdvertise record);

    @PostMapping(value = "/home/advertise/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody AdHomeAdvertise record);
}
