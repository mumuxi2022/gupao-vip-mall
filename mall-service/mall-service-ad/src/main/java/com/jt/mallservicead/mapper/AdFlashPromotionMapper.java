package com.jt.mallservicead.mapper;

import com.jt.model.AdFlashPromotion;
import com.jt.model.AdFlashPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdFlashPromotionMapper {
    long countByExample(AdFlashPromotionExample example);

    int deleteByExample(AdFlashPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdFlashPromotion record);

    int insertSelective(AdFlashPromotion record);

    List<AdFlashPromotion> selectByExample(AdFlashPromotionExample example);

    AdFlashPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdFlashPromotion record, @Param("example") AdFlashPromotionExample example);

    int updateByExample(@Param("record") AdFlashPromotion record, @Param("example") AdFlashPromotionExample example);

    int updateByPrimaryKeySelective(AdFlashPromotion record);

    int updateByPrimaryKey(AdFlashPromotion record);
}