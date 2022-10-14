package com.jt.mallservicead.mapper;

import com.jt.model.AdHomeRecommendProduct;
import com.jt.model.AdHomeRecommendProductExample;
import com.jt.model.AdHomeRecommendSubject;
import com.jt.model.AdHomeRecommendSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdHomeRecommendSubjectMapper {
    long countByExample(AdHomeRecommendSubjectExample example);

    int deleteByExample(AdHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeRecommendSubject record);

    int insertSelective(AdHomeRecommendSubject record);

    List<AdHomeRecommendSubject> selectByExample(AdHomeRecommendSubjectExample example);

    AdHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdHomeRecommendSubject record, @Param("example") AdHomeRecommendSubjectExample example);

    int updateByExample(@Param("record") AdHomeRecommendSubject record, @Param("example") AdHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(AdHomeRecommendSubject record);

    int updateByPrimaryKey(AdHomeRecommendSubject record);

    List<Long> listAllSubjectId();
}