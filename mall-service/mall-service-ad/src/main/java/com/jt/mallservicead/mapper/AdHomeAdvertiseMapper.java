package com.jt.mallservicead.mapper;

import com.jt.model.AdHomeAdvertise;
import com.jt.model.AdHomeAdvertiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdHomeAdvertiseMapper {
    long countByExample(AdHomeAdvertiseExample example);

    int deleteByExample(AdHomeAdvertiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeAdvertise record);

    int insertSelective(AdHomeAdvertise record);

    List<AdHomeAdvertise> selectByExample(AdHomeAdvertiseExample example);

    AdHomeAdvertise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdHomeAdvertise record, @Param("example") AdHomeAdvertiseExample example);

    int updateByExample(@Param("record") AdHomeAdvertise record, @Param("example") AdHomeAdvertiseExample example);

    int updateByPrimaryKeySelective(AdHomeAdvertise record);

    int updateByPrimaryKey(AdHomeAdvertise record);
}