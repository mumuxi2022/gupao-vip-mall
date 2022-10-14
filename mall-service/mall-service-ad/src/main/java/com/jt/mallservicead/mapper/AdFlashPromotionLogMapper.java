package com.jt.mallservicead.mapper;

import com.jt.model.AdFlashPromotionLog;
import com.jt.model.AdFlashPromotionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdFlashPromotionLogMapper {
    long countByExample(AdFlashPromotionLogExample example);

    int deleteByExample(AdFlashPromotionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdFlashPromotionLog record);

    int insertSelective(AdFlashPromotionLog record);

    List<AdFlashPromotionLog> selectByExample(AdFlashPromotionLogExample example);

    AdFlashPromotionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdFlashPromotionLog record, @Param("example") AdFlashPromotionLogExample example);

    int updateByExample(@Param("record") AdFlashPromotionLog record, @Param("example") AdFlashPromotionLogExample example);

    int updateByPrimaryKeySelective(AdFlashPromotionLog record);

    int updateByPrimaryKey(AdFlashPromotionLog record);
}