package com.jt.feign;

import com.jt.model.GoodsProductAttribute;
import com.jt.model.GoodsProductAttributeExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductAttributeFeign {

    @PostMapping(value = "/productAttribute/countByExample")
    long countByExample(@RequestBody GoodsProductAttributeExample example);

    @PostMapping(value = "/productAttribute/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductAttributeExample example);

    @DeleteMapping(value = "/productAttribute/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/productAttribute/insert")
    int insert(@RequestBody GoodsProductAttribute record);

    @PostMapping(value = "/productAttribute/insertSelective")
    int insertSelective(@RequestBody GoodsProductAttribute record);

    @PostMapping(value = "/productAttribute/selectByExample")
    List<GoodsProductAttribute> selectByExample(@RequestBody GoodsProductAttributeExample example);

    @GetMapping(value = "/productAttribute/selectByPrimaryKey")
    GoodsProductAttribute selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/productAttribute/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/productAttribute/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/productAttribute/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProductAttribute record);

    @PostMapping(value = "/productAttribute/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProductAttribute record);

}
