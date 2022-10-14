package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsProductLadder;
import com.jt.model.GoodsProductLadderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductLadderMapper {
    long countByExample(GoodsProductLadderExample example);

    int deleteByExample(GoodsProductLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductLadder record);

    int insertSelective(GoodsProductLadder record);

    List<GoodsProductLadder> selectByExample(GoodsProductLadderExample example);

    GoodsProductLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProductLadder record, @Param("example") GoodsProductLadderExample example);

    int updateByExample(@Param("record") GoodsProductLadder record, @Param("example") GoodsProductLadderExample example);

    int updateByPrimaryKeySelective(GoodsProductLadder record);

    int updateByPrimaryKey(GoodsProductLadder record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<GoodsProductLadder> productLadderList);
}