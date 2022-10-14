package com.jt.feign;

import com.jt.model.GoodsProductAttributeValue;
import com.jt.model.GoodsProductAttributeValueExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductAttributeValueFeign {

    @PostMapping(value = "/productAttributeValue/countByExample")
    long countByExample(@RequestBody GoodsProductAttributeValueExample example);

    @PostMapping(value = "/productAttributeValue/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductAttributeValueExample example);

    @DeleteMapping(value = "/productAttributeValue/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/productAttributeValue/insert")
    int insert(@RequestBody GoodsProductAttributeValue record);

    @PostMapping(value = "/productAttributeValue/insertSelective")
    int insertSelective(@RequestBody GoodsProductAttributeValue record);

    @PostMapping(value = "/productAttributeValue/selectByExample")
    List<GoodsProductAttributeValue> selectByExample(@RequestBody GoodsProductAttributeValueExample example);

    @GetMapping(value = "/productAttributeValue/selectByPrimaryKey")
    GoodsProductAttributeValue selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/productAttributeValue/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/productAttributeValue/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/productAttributeValue/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProductAttributeValue record);

    @PostMapping(value = "/productAttributeValue/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProductAttributeValue record);

}
