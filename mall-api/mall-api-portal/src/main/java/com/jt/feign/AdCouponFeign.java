package com.jt.feign;

import com.jt.model.AdCoupon;
import com.jt.model.AdCouponExample;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdCouponFeign {

    @GetMapping(value = "/coupon/getAvailableCouponList")
    List<AdCoupon> getAvailableCouponList(@RequestParam("productId") Long productId, @RequestParam("productCategoryId") Long productCategoryId);

    @PostMapping(value = "/coupon/countByExample")
    long countByExample(@RequestBody AdCouponExample example);

    @PostMapping(value = "/coupon/deleteByExample")
    int deleteByExample(@RequestBody AdCouponExample example);

    @DeleteMapping(value = "/coupon/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/coupon/insert")
    int insert(@RequestBody AdCoupon record);

    @PostMapping(value = "/coupon/insertSelective")
    int insertSelective(@RequestBody AdCoupon record);

    @PostMapping(value = "/coupon/selectByExample")
    List<AdCoupon> selectByExample(@RequestBody AdCouponExample example);

    @GetMapping(value = "/coupon/selectByPrimaryKey")
    AdCoupon selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/coupon/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/coupon/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/coupon/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody AdCoupon record);

    @PostMapping(value = "/coupon/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody AdCoupon record);
}
