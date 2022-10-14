package com.jt.mallservicegoods.mapper;

import com.jt.model.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 搜索商品管理自定义Dao
 */
@Repository
public interface EsProductMapper {
    /**
     * 获取指定ID的搜索商品
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
