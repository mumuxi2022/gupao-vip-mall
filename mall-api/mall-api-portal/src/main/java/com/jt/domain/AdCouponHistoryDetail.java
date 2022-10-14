package com.jt.domain;

import com.jt.model.AdCoupon;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductRelation;

import java.util.List;

/**
 * 优惠券领取历史详情（包括优惠券信息和关联关系）
 */
public class AdCouponHistoryDetail extends AdCouponHistory {
    //相关优惠券信息
    private AdCoupon coupon;
    //优惠券关联商品
    private List<AdCouponProductRelation> productRelationList;
    //优惠券关联商品分类
    private List<AdCouponProductCategoryRelation> categoryRelationList;

    public AdCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(AdCoupon coupon) {
        this.coupon = coupon;
    }

    public List<AdCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<AdCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<AdCouponProductCategoryRelation> getCategoryRelationList() {
        return categoryRelationList;
    }

    public void setCategoryRelationList(List<AdCouponProductCategoryRelation> categoryRelationList) {
        this.categoryRelationList = categoryRelationList;
    }
}
