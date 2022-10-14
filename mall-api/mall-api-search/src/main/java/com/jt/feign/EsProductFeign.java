package com.jt.feign;


import com.jt.model.EsProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 搜索商品管理自定义Dao
 */
@FeignClient("mall-service-goods")
public interface EsProductFeign {
    /**
     * 获取指定ID的搜索商品
     */
    @GetMapping(value = "/esproduct/getAllEsProductList")
    List<EsProduct> getAllEsProductList(@RequestParam("id") Long id);
}
