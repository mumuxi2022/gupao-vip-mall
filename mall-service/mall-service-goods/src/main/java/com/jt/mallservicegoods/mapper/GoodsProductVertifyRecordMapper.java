package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductVertifyRecord;
import com.jt.model.GoodsProductVertifyRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductVertifyRecordMapper {
    long countByExample(GoodsProductVertifyRecordExample example);

    int deleteByExample(GoodsProductVertifyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductVertifyRecord record);

    int insertSelective(GoodsProductVertifyRecord record);

    List<GoodsProductVertifyRecord> selectByExample(GoodsProductVertifyRecordExample example);

    GoodsProductVertifyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductVertifyRecord record, @Param("example") GoodsProductVertifyRecordExample example);

    int updateByExample(@Param("record") GoodsProductVertifyRecord record, @Param("example") GoodsProductVertifyRecordExample example);

    int updateByPrimaryKeySelective(GoodsProductVertifyRecord record);

    int updateByPrimaryKey(GoodsProductVertifyRecord record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<GoodsProductVertifyRecord> list);
}