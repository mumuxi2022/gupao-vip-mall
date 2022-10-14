package com.jt.feign;

import com.jt.model.AdFlashPromotion;
import com.jt.model.AdFlashPromotionExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdFlashPromotionFeign {
    @PostMapping(value = "/flash/listByExample")
    List<AdFlashPromotion> listByExample(@RequestBody AdFlashPromotionExample adFlashPromotionExample);
}
