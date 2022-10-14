package com.jt.domain;

import com.jt.dto.FlashPromotionProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 首页秒杀场次信息封装
 */
@Getter
@Setter
public class HomeFlashPromotion {
    //本场开始时间
    private Date startTime;
    //本场结束时间
    private Date endTime;
    //下场开始时间
    private Date nextStartTime;
    //下场结束时间
    private Date nextEndTime;
    //属于该秒杀活动的商品
    private List<FlashPromotionProduct> productList;
}
