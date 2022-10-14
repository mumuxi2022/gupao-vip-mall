package com.jt.feign;

import com.jt.mallcommon.api.CommonResult;
import com.jt.model.ContextSubjectProductRelation;
import com.jt.model.ContextSubjectProductRelationExample;
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
public interface ContextSubjectProductRelationFeign {

    @PostMapping(value = "/subjectProductRelation/insertList")
    CommonResult<Integer> insertList(@RequestBody List<ContextSubjectProductRelation> dataList);

    @PostMapping(value = "/subjectProductRelation/deleteByExample")
    CommonResult<Integer> deleteByExample(@RequestBody ContextSubjectProductRelationExample subjectProductRelationExample);

    @GetMapping(value = "/subjectProductRelation/getListByProductId")
    CommonResult<List<ContextSubjectProductRelation>> getListByProductId(@RequestParam("productId") Long productId);
}
