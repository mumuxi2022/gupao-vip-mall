package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductOperateLog;
import com.jt.model.GoodsProductOperateLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductOperateLogMapper {
    long countByExample(GoodsProductOperateLogExample example);

    int deleteByExample(GoodsProductOperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductOperateLog record);

    int insertSelective(GoodsProductOperateLog record);

    List<GoodsProductOperateLog> selectByExample(GoodsProductOperateLogExample example);

    GoodsProductOperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductOperateLog record, @Param("example") GoodsProductOperateLogExample example);

    int updateByExample(@Param("record") GoodsProductOperateLog record, @Param("example") GoodsProductOperateLogExample example);

    int updateByPrimaryKeySelective(GoodsProductOperateLog record);

    int updateByPrimaryKey(GoodsProductOperateLog record);
}