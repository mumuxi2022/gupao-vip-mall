package com.jt.mallservicead.mapper;

import com.jt.model.AdCouponProductRelation;
import com.jt.model.AdCouponProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdCouponProductRelationMapper {
    long countByExample(AdCouponProductRelationExample example);

    int deleteByExample(AdCouponProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponProductRelation record);

    int insertSelective(AdCouponProductRelation record);

    List<AdCouponProductRelation> selectByExample(AdCouponProductRelationExample example);

    AdCouponProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdCouponProductRelation record, @Param("example") AdCouponProductRelationExample example);

    int updateByExample(@Param("record") AdCouponProductRelation record, @Param("example") AdCouponProductRelationExample example);

    int updateByPrimaryKeySelective(AdCouponProductRelation record);

    int updateByPrimaryKey(AdCouponProductRelation record);

    /**
     * 批量创建
     */
    int insertList(@Param("list")List<AdCouponProductRelation> productRelationList);
}