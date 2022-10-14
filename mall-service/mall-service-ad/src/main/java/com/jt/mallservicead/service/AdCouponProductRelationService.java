package com.jt.mallservicead.service;


import com.jt.model.AdCouponProductRelation;
import com.jt.model.AdCouponProductRelationExample;

import java.util.List;

/**
 * 优惠券商品关联管理Service
 */
public interface AdCouponProductRelationService {

    long countByExample(AdCouponProductRelationExample example);

    int deleteByExample(AdCouponProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponProductRelation record);

    int insertSelective(AdCouponProductRelation record);

    List<AdCouponProductRelation> selectByExample(AdCouponProductRelationExample example);

    AdCouponProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(AdCouponProductRelation record,AdCouponProductRelationExample example);

    int updateByExample(AdCouponProductRelation record, AdCouponProductRelationExample example);

    int updateByPrimaryKeySelective(AdCouponProductRelation record);

    int updateByPrimaryKey(AdCouponProductRelation record);

}
