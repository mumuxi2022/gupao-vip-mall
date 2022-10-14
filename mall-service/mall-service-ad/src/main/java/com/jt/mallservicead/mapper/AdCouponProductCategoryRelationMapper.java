package com.jt.mallservicead.mapper;

import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdCouponProductCategoryRelationMapper {
    long countByExample(AdCouponProductCategoryRelationExample example);

    int deleteByExample(AdCouponProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdCouponProductCategoryRelation record);

    int insertSelective(AdCouponProductCategoryRelation record);

    List<AdCouponProductCategoryRelation> selectByExample(AdCouponProductCategoryRelationExample example);

    AdCouponProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdCouponProductCategoryRelation record, @Param("example") AdCouponProductCategoryRelationExample example);

    int updateByExample(@Param("record") AdCouponProductCategoryRelation record, @Param("example") AdCouponProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(AdCouponProductCategoryRelation record);

    int updateByPrimaryKey(AdCouponProductCategoryRelation record);

    /**
     * 批量创建
     */
    int insertList(@Param("list")List<AdCouponProductCategoryRelation> productCategoryRelationList);
}