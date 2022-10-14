package com.jt.mallservicead.mapper;

import com.jt.model.AdHomeBrand;
import com.jt.model.AdHomeBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdHomeBrandMapper {
    long countByExample(AdHomeBrandExample example);

    int deleteByExample(AdHomeBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeBrand record);

    int insertSelective(AdHomeBrand record);

    List<AdHomeBrand> selectByExample(AdHomeBrandExample example);

    AdHomeBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdHomeBrand record, @Param("example") AdHomeBrandExample example);

    int updateByExample(@Param("record") AdHomeBrand record, @Param("example") AdHomeBrandExample example);

    int updateByPrimaryKeySelective(AdHomeBrand record);

    int updateByPrimaryKey(AdHomeBrand record);

    List<AdHomeBrand> selectAll();
}