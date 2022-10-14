package com.jt.domain;

import com.jt.model.AdHomeAdvertise;
import com.jt.model.ContextSubject;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 首页内容返回信息封装
 */
@Getter
@Setter
public class HomeContentResult {
    //轮播广告
    private List<AdHomeAdvertise> advertiseList;
    //推荐品牌
    private List<GoodsBrand> brandList;
    //当前秒杀场次
    private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<GoodsProduct> newProductList;
    //人气推荐
    private List<GoodsProduct> hotProductList;
    //推荐专题
    private List<ContextSubject> subjectList;
}
