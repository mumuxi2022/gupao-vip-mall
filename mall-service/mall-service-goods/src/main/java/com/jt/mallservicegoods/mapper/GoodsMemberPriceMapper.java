package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsMemberPrice;
import com.jt.model.GoodsMemberPriceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMemberPriceMapper {
    long countByExample(GoodsMemberPriceExample example);

    int deleteByExample(GoodsMemberPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsMemberPrice record);

    int insertSelective(GoodsMemberPrice record);

    List<GoodsMemberPrice> selectByExample(GoodsMemberPriceExample example);

    GoodsMemberPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsMemberPrice record, @Param("example") GoodsMemberPriceExample example);

    int updateByExample(@Param("record") GoodsMemberPrice record, @Param("example") GoodsMemberPriceExample example);

    int updateByPrimaryKeySelective(GoodsMemberPrice record);

    int updateByPrimaryKey(GoodsMemberPrice record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<GoodsMemberPrice> memberPriceList);
}