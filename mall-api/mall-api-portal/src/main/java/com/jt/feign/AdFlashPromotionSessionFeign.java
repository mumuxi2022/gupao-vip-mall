package com.jt.feign;

import com.jt.model.AdFlashPromotionSession;
import com.jt.model.AdFlashPromotionSessionExample;
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
public interface AdFlashPromotionSessionFeign {
    @PostMapping(value = "/flashSession/listByExample")
    List<AdFlashPromotionSession> listByExample(@RequestBody AdFlashPromotionSessionExample adFlashPromotionSessionExample);
}
