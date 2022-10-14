package com.jt.mallservicead.service;


import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductCategoryRelationExample;

import java.util.List;

/**
 * 优惠券商品分类关联管理Service
 */
public interface AdCouponProductCategoryRelationService {

    long countByExample(AdCouponProductCategoryRelationExample example);

    int deleteByExample(AdCouponProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponProductCategoryRelation record);

    int insertSelective(AdCouponProductCategoryRelation record);

    List<AdCouponProductCategoryRelation> selectByExample(AdCouponProductCategoryRelationExample example);

    AdCouponProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(AdCouponProductCategoryRelation record,AdCouponProductCategoryRelationExample example);

    int updateByExample(AdCouponProductCategoryRelation record,AdCouponProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(AdCouponProductCategoryRelation record);

    int updateByPrimaryKey(AdCouponProductCategoryRelation record);
}
