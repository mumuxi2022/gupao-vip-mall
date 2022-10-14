package com.jt.mallservicegoods.service;

import com.jt.model.EsProduct;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 搜索商品管理自定义Service
 */
public interface EsProductService {
    /**
     * 获取指定ID的搜索商品
     */
    List<EsProduct> getAllEsProductList(Long id);

}
