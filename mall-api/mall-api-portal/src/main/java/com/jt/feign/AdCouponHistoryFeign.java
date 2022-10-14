package com.jt.feign;

import com.jt.domain.AdCouponHistoryDetail;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponHistoryExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdCouponHistoryFeign {

    @PostMapping(value = "/couponHistory/countByExample")
    long countByExample(@RequestBody AdCouponHistoryExample example);

    @PostMapping(value = "/couponHistory/deleteByExample")
    int deleteByExample(@RequestBody AdCouponHistoryExample example);

    @DeleteMapping(value = "/couponHistory/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/couponHistory/insert")
    int insert(@RequestBody AdCouponHistory record);

    @PostMapping(value = "/couponHistory/insertSelective")
    int insertSelective(@RequestBody AdCouponHistory record);

    @PostMapping(value = "/couponHistory/selectByExample")
    List<AdCouponHistory> selectByExample(@RequestBody AdCouponHistoryExample example);

    @GetMapping(value = "/couponHistory/selectByPrimaryKey")
    AdCouponHistory selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/couponHistory/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/couponHistory/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/couponHistory/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody AdCouponHistory record);

    @PostMapping(value = "/couponHistory/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody AdCouponHistory record);

    @GetMapping(value = "/couponHistory/getDetailList")
    List<AdCouponHistoryDetail> getDetailList(@RequestParam("memberId") Long memberId);

    @GetMapping(value = "/couponHistory/getCouponList")
    List<AdCoupon> getCouponList(@RequestParam("memberId") Long memberId, @RequestParam("useStatus") Integer useStatus);
}
