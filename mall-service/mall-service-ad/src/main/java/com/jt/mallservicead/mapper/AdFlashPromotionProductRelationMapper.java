package com.jt.mallservicead.mapper;

import com.jt.dto.AdFlashPromotionProduct;
import com.jt.model.AdFlashPromotionProductRelation;
import com.jt.model.AdFlashPromotionProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdFlashPromotionProductRelationMapper {
    long countByExample(AdFlashPromotionProductRelationExample example);

    int deleteByExample(AdFlashPromotionProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdFlashPromotionProductRelation record);

    int insertSelective(AdFlashPromotionProductRelation record);

    List<AdFlashPromotionProductRelation> selectByExample(AdFlashPromotionProductRelationExample example);

    AdFlashPromotionProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdFlashPromotionProductRelation record, @Param("example") AdFlashPromotionProductRelationExample example);

    int updateByExample(@Param("record") AdFlashPromotionProductRelation record, @Param("example") AdFlashPromotionProductRelationExample example);

    int updateByPrimaryKeySelective(AdFlashPromotionProductRelation record);

    int updateByPrimaryKey(AdFlashPromotionProductRelation record);

    /**
     * 获取限时购及相关商品信息
     */
    List<AdFlashPromotionProductRelation> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);

    List<AdFlashPromotionProductRelation> listBySomeId(Long flashPromotionId,Long sessionId);

}