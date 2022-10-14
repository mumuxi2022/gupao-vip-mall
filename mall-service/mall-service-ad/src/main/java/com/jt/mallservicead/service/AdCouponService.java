package com.jt.mallservicead.service;

import com.jt.dto.AdCouponParam;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 优惠券管理Service
 */
public interface AdCouponService {
    /**
     * 添加优惠券
     */
    @Transactional
    int create(AdCouponParam couponParam);

    /**
     * 根据优惠券id删除优惠券
     */
    @Transactional
    int delete(Long id);

    /**
     * 根据优惠券id更新优惠券信息
     */
    @Transactional
    int update(Long id, AdCouponParam couponParam);

    /**
     * 分页获取优惠券列表
     */
    List<AdCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 获取优惠券详情
     * @param id 优惠券表id
     */
    AdCouponParam getItem(Long id);

    List<AdCoupon> getAvailableCouponList(Long productId, Long productCategoryId);

    long countByExample(AdCouponExample example);

    int deleteByExample(AdCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCoupon record);

    int insertSelective(AdCoupon record);

    List<AdCoupon> selectByExample(AdCouponExample example);

    AdCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(AdCoupon record,AdCouponExample example);

    int updateByExample(AdCoupon record,AdCouponExample example);

    int updateByPrimaryKeySelective(AdCoupon record);

    int updateByPrimaryKey(AdCoupon record);
}
