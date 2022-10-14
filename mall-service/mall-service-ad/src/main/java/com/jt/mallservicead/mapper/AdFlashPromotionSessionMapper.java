package com.jt.mallservicead.mapper;

import com.jt.model.AdFlashPromotionSession;
import com.jt.model.AdFlashPromotionSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdFlashPromotionSessionMapper {
    long countByExample(AdFlashPromotionSessionExample example);

    int deleteByExample(AdFlashPromotionSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdFlashPromotionSession record);

    int insertSelective(AdFlashPromotionSession record);

    List<AdFlashPromotionSession> selectByExample(AdFlashPromotionSessionExample example);

    AdFlashPromotionSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdFlashPromotionSession record, @Param("example") AdFlashPromotionSessionExample example);

    int updateByExample(@Param("record") AdFlashPromotionSession record, @Param("example") AdFlashPromotionSessionExample example);

    int updateByPrimaryKeySelective(AdFlashPromotionSession record);

    int updateByPrimaryKey(AdFlashPromotionSession record);
}