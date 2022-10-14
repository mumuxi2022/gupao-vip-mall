package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsCommentReplay;
import com.jt.model.GoodsCommentReplayExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsCommentReplayMapper {
    long countByExample(GoodsCommentReplayExample example);

    int deleteByExample(GoodsCommentReplayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCommentReplay record);

    int insertSelective(GoodsCommentReplay record);

    List<GoodsCommentReplay> selectByExample(GoodsCommentReplayExample example);

    GoodsCommentReplay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCommentReplay record, @Param("example") GoodsCommentReplayExample example);

    int updateByExample(@Param("record") GoodsCommentReplay record, @Param("example") GoodsCommentReplayExample example);

    int updateByPrimaryKeySelective(GoodsCommentReplay record);

    int updateByPrimaryKey(GoodsCommentReplay record);
}