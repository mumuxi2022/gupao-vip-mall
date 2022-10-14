package com.jt.mallservicead.mapper;

import com.jt.model.AdHomeRecommendProduct;
import com.jt.model.AdHomeRecommendProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdHomeRecommendProductMapper {
    long countByExample(AdHomeRecommendProductExample example);

    int deleteByExample(AdHomeRecommendProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeRecommendProduct record);

    int insertSelective(AdHomeRecommendProduct record);

    List<AdHomeRecommendProduct> selectByExample(AdHomeRecommendProductExample example);

    AdHomeRecommendProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdHomeRecommendProduct record, @Param("example") AdHomeRecommendProductExample example);

    int updateByExample(@Param("record") AdHomeRecommendProduct record, @Param("example") AdHomeRecommendProductExample example);

    int updateByPrimaryKeySelective(AdHomeRecommendProduct record);

    int updateByPrimaryKey(AdHomeRecommendProduct record);

    List<Long> listAllProductId();
}