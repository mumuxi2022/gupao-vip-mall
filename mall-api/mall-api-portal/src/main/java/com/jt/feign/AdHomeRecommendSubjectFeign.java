package com.jt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdHomeRecommendSubjectFeign {

    @GetMapping(value = "/home/recommendSubject/listAllSubjectId")
    List<Long> listAllSubjectId();
}
