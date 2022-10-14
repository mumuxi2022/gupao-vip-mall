package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextMemberReport;
import com.jt.model.ContextMemberReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextMemberReportMapper {
    long countByExample(ContextMemberReportExample example);

    int deleteByExample(ContextMemberReportExample example);

    int insert(ContextMemberReport record);

    int insertSelective(ContextMemberReport record);

    List<ContextMemberReport> selectByExample(ContextMemberReportExample example);

    int updateByExampleSelective(@Param("record") ContextMemberReport record, @Param("example") ContextMemberReportExample example);

    int updateByExample(@Param("record") ContextMemberReport record, @Param("example") ContextMemberReportExample example);
}