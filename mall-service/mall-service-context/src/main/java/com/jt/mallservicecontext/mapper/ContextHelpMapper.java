package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextHelp;
import com.jt.model.ContextHelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextHelpMapper {
    long countByExample(ContextHelpExample example);

    int deleteByExample(ContextHelpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextHelp record);

    int insertSelective(ContextHelp record);

    List<ContextHelp> selectByExampleWithBLOBs(ContextHelpExample example);

    List<ContextHelp> selectByExample(ContextHelpExample example);

    ContextHelp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextHelp record, @Param("example") ContextHelpExample example);

    int updateByExampleWithBLOBs(@Param("record") ContextHelp record, @Param("example") ContextHelpExample example);

    int updateByExample(@Param("record") ContextHelp record, @Param("example") ContextHelpExample example);

    int updateByPrimaryKeySelective(ContextHelp record);

    int updateByPrimaryKeyWithBLOBs(ContextHelp record);

    int updateByPrimaryKey(ContextHelp record);
}