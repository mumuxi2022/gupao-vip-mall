package com.jt.feign;

import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStockExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsSkuStockFeign {

    @PostMapping(value = "/sku/countByExample")
    long countByExample(@RequestBody GoodsSkuStockExample example);

    @PostMapping(value = "/sku/deleteByExample")
    int deleteByExample(@RequestBody GoodsSkuStockExample example);

    @DeleteMapping(value = "/sku/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/sku/insert")
    int insert(@RequestBody GoodsSkuStock record);

    @PostMapping(value = "/sku/insertSelective")
    int insertSelective(@RequestBody GoodsSkuStock record);

    @PostMapping(value = "/sku/selectByExample")
    List<GoodsSkuStock> selectByExample(@RequestBody GoodsSkuStockExample example);

    @GetMapping(value = "/sku/selectByPrimaryKey")
    GoodsSkuStock selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/sku/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/sku/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/sku/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsSkuStock record);

    @PostMapping(value = "/sku/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsSkuStock record);

}
