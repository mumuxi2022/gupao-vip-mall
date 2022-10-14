package com.jt.mallservicead.service;


import com.jt.domain.AdCouponHistoryDetail;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponExample;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券领取记录管理Service
 */
public interface AdCouponHistoryService {
    /**
     * 分页查询优惠券领取记录
     * @param couponId 优惠券id
     * @param useStatus 使用状态
     * @param orderSn 使用订单号码
     */
    List<AdCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);

    long countByExample(AdCouponHistoryExample example);

    int deleteByExample(AdCouponHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponHistory record);

    int insertSelective(AdCouponHistory record);

    List<AdCouponHistory> selectByExample(AdCouponHistoryExample example);

    AdCouponHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(AdCouponHistory record,AdCouponHistoryExample example);

    int updateByExample(AdCouponHistory record,AdCouponHistoryExample example);

    int updateByPrimaryKeySelective(AdCouponHistory record);

    int updateByPrimaryKey(AdCouponHistory record);

    List<AdCouponHistoryDetail> getDetailList(Long memberId);

    List<AdCoupon> getCouponList(Long memberId, Integer useStatus);
}
