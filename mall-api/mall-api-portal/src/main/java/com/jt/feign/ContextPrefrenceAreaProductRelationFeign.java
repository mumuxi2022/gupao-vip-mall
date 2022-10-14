package com.jt.feign;

import com.jt.mallcommon.api.CommonResult;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:53
 */
@FeignClient("mall-service-context")
public interface ContextPrefrenceAreaProductRelationFeign {

    @PostMapping(value = "/prefrenceAreaProductRelation/insertList")
    CommonResult<Integer> insertList(@RequestBody List<ContextPrefrenceAreaProductRelation> dataList);

    @PostMapping(value = "/prefrenceAreaProductRelation/deleteByExample")
    CommonResult<Integer> deleteByExample(@RequestBody ContextPrefrenceAreaProductRelationExample prefrenceAreaProductRelationExample);

    @GetMapping(value = "/prefrenceAreaProductRelation/getListByProductId")
    CommonResult<List<ContextPrefrenceAreaProductRelation>> getListByProductId(@RequestParam("productId") Long productId);
}
