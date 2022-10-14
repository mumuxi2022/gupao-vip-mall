package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextSubject;
import com.jt.model.ContextSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextSubjectMapper {
    long countByExample(ContextSubjectExample example);

    int deleteByExample(ContextSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextSubject record);

    int insertSelective(ContextSubject record);

    List<ContextSubject> selectByExampleWithBLOBs(ContextSubjectExample example);

    List<ContextSubject> selectByExample(ContextSubjectExample example);

    ContextSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextSubject record, @Param("example") ContextSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ContextSubject record, @Param("example") ContextSubjectExample example);

    int updateByExample(@Param("record") ContextSubject record, @Param("example") ContextSubjectExample example);

    int updateByPrimaryKeySelective(ContextSubject record);

    int updateByPrimaryKeyWithBLOBs(ContextSubject record);

    int updateByPrimaryKey(ContextSubject record);

    /**
     * 获取推荐专题
     */
    List<ContextSubject> getRecommendSubjectList(List<Long> ids,Integer offset, Integer limit);
}