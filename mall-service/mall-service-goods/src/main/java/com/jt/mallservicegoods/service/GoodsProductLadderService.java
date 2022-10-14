package com.jt.mallservicegoods.service;


import com.jt.model.GoodsProductLadder;
import com.jt.model.GoodsProductLadderExample;

import java.util.List;

public interface GoodsProductLadderService {

    long countByExample(GoodsProductLadderExample example);

    int deleteByExample(GoodsProductLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductLadder record);

    int insertSelective(GoodsProductLadder record);

    List<GoodsProductLadder> selectByExample(GoodsProductLadderExample example);

    GoodsProductLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProductLadder record, GoodsProductLadderExample example);

    int updateByExample(GoodsProductLadder record,GoodsProductLadderExample example);

    int updateByPrimaryKeySelective(GoodsProductLadder record);

    int updateByPrimaryKey(GoodsProductLadder record);
}
