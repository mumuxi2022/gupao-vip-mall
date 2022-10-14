package com.jt.mallservicead.mapper;

import com.jt.domain.AdCouponHistoryDetail;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdCouponHistoryMapper {
    long countByExample(AdCouponHistoryExample example);

    int deleteByExample(AdCouponHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponHistory record);

    int insertSelective(AdCouponHistory record);

    List<AdCouponHistory> selectByExample(AdCouponHistoryExample example);

    AdCouponHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdCouponHistory record, @Param("example") AdCouponHistoryExample example);

    int updateByExample(@Param("record") AdCouponHistory record, @Param("example") AdCouponHistoryExample example);

    int updateByPrimaryKeySelective(AdCouponHistory record);

    int updateByPrimaryKey(AdCouponHistory record);

    List<AdCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    List<AdCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}