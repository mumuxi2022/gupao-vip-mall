package com.jt.dto;

import com.jt.model.GoodsProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 */
@Getter
@Setter
public class FlashPromotionProduct extends GoodsProduct {
    //秒杀价格
    private BigDecimal flashPromotionPrice;
    //用于秒杀到数量
    private Integer flashPromotionCount;
    //秒杀限购数量
    private Integer flashPromotionLimit;
}
