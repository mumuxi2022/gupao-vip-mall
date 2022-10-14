package com.jt.feign;

import com.jt.model.AdCouponProductRelation;
import com.jt.model.AdCouponProductRelationExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdCouponProductRelationFeign {

    @PostMapping(value = "/couponProductRelation/countByExample")
    long countByExample(@RequestBody AdCouponProductRelationExample example);

    @PostMapping(value = "/couponProductRelation/deleteByExample")
    int deleteByExample(@RequestBody AdCouponProductRelationExample example);

    @DeleteMapping(value = "/couponProductRelation/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/couponProductRelation/insert")
    int insert(@RequestBody AdCouponProductRelation record);

    @PostMapping(value = "/couponProductRelation/insertSelective")
    int insertSelective(@RequestBody AdCouponProductRelation record);

    @PostMapping(value = "/couponProductRelation/selectByExample")
    List<AdCouponProductRelation> selectByExample(@RequestBody AdCouponProductRelationExample example);

    @GetMapping(value = "/couponProductRelation/selectByPrimaryKey")
    AdCouponProductRelation selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/couponProductRelation/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/couponProductRelation/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/couponProductRelation/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody AdCouponProductRelation record);

    @PostMapping(value = "/couponProductRelation/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody AdCouponProductRelation record);

}
