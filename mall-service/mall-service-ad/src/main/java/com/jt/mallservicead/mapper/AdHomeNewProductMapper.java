package com.jt.mallservicead.mapper;

import com.jt.model.AdHomeNewProduct;
import com.jt.model.AdHomeNewProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdHomeNewProductMapper {
    long countByExample(AdHomeNewProductExample example);

    int deleteByExample(AdHomeNewProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeNewProduct record);

    int insertSelective(AdHomeNewProduct record);

    List<AdHomeNewProduct> selectByExample(AdHomeNewProductExample example);

    AdHomeNewProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdHomeNewProduct record, @Param("example") AdHomeNewProductExample example);

    int updateByExample(@Param("record") AdHomeNewProduct record, @Param("example") AdHomeNewProductExample example);

    int updateByPrimaryKeySelective(AdHomeNewProduct record);

    int updateByPrimaryKey(AdHomeNewProduct record);

    List<Long> listAllProductId();
}