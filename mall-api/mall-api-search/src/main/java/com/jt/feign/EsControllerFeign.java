package com.jt.feign;


import com.jt.mallcommon.api.CommonResult;
import com.jt.model.EsProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 搜索商品管理自定义Dao
 */
@FeignClient("mall-search")
public interface EsControllerFeign {
    /**
     * 获取指定ID的搜索商品
     */
    @PostMapping(value = "/esProduct/create")
    CommonResult<EsProduct> create(@RequestParam("id") Long id);

    @GetMapping(value = "/esProduct/delete")
    CommonResult<Object> delete(@RequestParam("id") Long id);
}
