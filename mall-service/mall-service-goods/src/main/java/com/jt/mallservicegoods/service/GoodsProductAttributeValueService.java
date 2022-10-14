package com.jt.mallservicegoods.service;


import com.jt.model.GoodsProductAttributeValue;
import com.jt.model.GoodsProductAttributeValueExample;

import java.util.List;

public interface GoodsProductAttributeValueService {

    long countByExample(GoodsProductAttributeValueExample example);

    int deleteByExample(GoodsProductAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductAttributeValue record);

    int insertSelective(GoodsProductAttributeValue record);

    List<GoodsProductAttributeValue> selectByExample(GoodsProductAttributeValueExample example);

    GoodsProductAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProductAttributeValue record, GoodsProductAttributeValueExample example);

    int updateByExample(GoodsProductAttributeValue record,GoodsProductAttributeValueExample example);

    int updateByPrimaryKeySelective(GoodsProductAttributeValue record);

    int updateByPrimaryKey(GoodsProductAttributeValue record);
}
