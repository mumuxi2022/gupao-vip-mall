package com.jt.feign;

import com.jt.model.AdFlashPromotionProductRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-ad")
public interface AdFlashPromotionProductRelationFeign {

    @GetMapping(value = "/flashProductRelation/listAll")
    List<AdFlashPromotionProductRelation> listBySomeId(@RequestParam("flashPromotionId") Long flashPromotionId,
                                                       @RequestParam("sessionId") Long sessionId);
}
