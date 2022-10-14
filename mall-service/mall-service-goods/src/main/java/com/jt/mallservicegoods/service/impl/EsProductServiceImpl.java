package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.EsProductMapper;
import com.jt.mallservicegoods.service.EsProductService;
import com.jt.model.EsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 搜索商品管理自定义Service实现类
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductMapper esProductMapper;

    @Override
    public List<EsProduct> getAllEsProductList(Long id) {
        return esProductMapper.getAllEsProductList(id);
    }


}
