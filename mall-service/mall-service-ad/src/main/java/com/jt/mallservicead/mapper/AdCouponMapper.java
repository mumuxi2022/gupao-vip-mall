package com.jt.mallservicead.mapper;

import com.jt.dto.AdCouponParam;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdCouponMapper {
    long countByExample(AdCouponExample example);

    int deleteByExample(AdCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCoupon record);

    int insertSelective(AdCoupon record);

    List<AdCoupon> selectByExample(AdCouponExample example);

    AdCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdCoupon record, @Param("example") AdCouponExample example);

    int updateByExample(@Param("record") AdCoupon record, @Param("example") AdCouponExample example);

    int updateByPrimaryKeySelective(AdCoupon record);

    int updateByPrimaryKey(AdCoupon record);

    /**
     * 获取优惠券详情包括绑定关系
     */
    AdCouponParam getItem(@Param("id") Long id);

    List<AdCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId")Long productCategoryId);
}