package com.jt.feign;

import com.jt.model.ContextSubject;
import com.jt.model.ContextSubjectExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:40
 */
@FeignClient("mall-service-context")
public interface ContextSubjectFeign {
    /**
     * 获取推荐专题
     */
    @GetMapping(value = "/subject/getRecommendBrandList")
    List<ContextSubject> getRecommendSubjectList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

    @PostMapping(value = "/subject/listByExample")
    List<ContextSubject> listByExample(@RequestBody ContextSubjectExample contextSubjectExample);
}
