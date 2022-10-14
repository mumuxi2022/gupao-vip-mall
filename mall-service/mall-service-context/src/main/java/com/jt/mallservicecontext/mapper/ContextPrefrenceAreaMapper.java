package com.jt.mallservicecontext.mapper;

import com.jt.model.ContextPrefrenceArea;
import com.jt.model.ContextPrefrenceAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextPrefrenceAreaMapper {
    long countByExample(ContextPrefrenceAreaExample example);

    int deleteByExample(ContextPrefrenceAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContextPrefrenceArea record);

    int insertSelective(ContextPrefrenceArea record);

    List<ContextPrefrenceArea> selectByExampleWithBLOBs(ContextPrefrenceAreaExample example);

    List<ContextPrefrenceArea> selectByExample(ContextPrefrenceAreaExample example);

    ContextPrefrenceArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContextPrefrenceArea record, @Param("example") ContextPrefrenceAreaExample example);

    int updateByExampleWithBLOBs(@Param("record") ContextPrefrenceArea record, @Param("example") ContextPrefrenceAreaExample example);

    int updateByExample(@Param("record") ContextPrefrenceArea record, @Param("example") ContextPrefrenceAreaExample example);

    int updateByPrimaryKeySelective(ContextPrefrenceArea record);

    int updateByPrimaryKeyWithBLOBs(ContextPrefrenceArea record);

    int updateByPrimaryKey(ContextPrefrenceArea record);
}