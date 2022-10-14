package com.jt.feign;

import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductCategoryRelationExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdCouponProductCategoryRelationFeign {

    @PostMapping(value = "/couponProductCategoryRelation/countByExample")
    long countByExample(@RequestBody AdCouponProductCategoryRelationExample example);

    @PostMapping(value = "/couponProductCategoryRelation/deleteByExample")
    int deleteByExample(@RequestBody AdCouponProductCategoryRelationExample example);

    @DeleteMapping(value = "/couponProductCategoryRelation/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/couponProductCategoryRelation/insert")
    int insert(@RequestBody AdCouponProductCategoryRelation record);

    @PostMapping(value = "/couponProductCategoryRelation/insertSelective")
    int insertSelective(@RequestBody AdCouponProductCategoryRelation record);

    @PostMapping(value = "/couponProductCategoryRelation/selectByExample")
    List<AdCouponProductCategoryRelation> selectByExample(@RequestBody AdCouponProductCategoryRelationExample example);

    @GetMapping(value = "/couponProductCategoryRelation/selectByPrimaryKey")
    AdCouponProductCategoryRelation selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/couponProductCategoryRelation/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/couponProductCategoryRelation/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/couponProductCategoryRelation/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody AdCouponProductCategoryRelation record);

    @PostMapping(value = "/couponProductCategoryRelation/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody AdCouponProductCategoryRelation record);

}
