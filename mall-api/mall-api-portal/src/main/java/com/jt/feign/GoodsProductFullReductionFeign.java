package com.jt.feign;

import com.jt.model.GoodsProductFullReduction;
import com.jt.model.GoodsProductFullReductionExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductFullReductionFeign {

    @PostMapping(value = "/productFullReduction/countByExample")
    long countByExample(@RequestBody GoodsProductFullReductionExample example);

    @PostMapping(value = "/productFullReduction/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductFullReductionExample example);

    @DeleteMapping(value = "/productFullReduction/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/productFullReduction/insert")
    int insert(@RequestBody GoodsProductFullReduction record);

    @PostMapping(value = "/productFullReduction/insertSelective")
    int insertSelective(@RequestBody GoodsProductFullReduction record);

    @PostMapping(value = "/productFullReduction/selectByExample")
    List<GoodsProductFullReduction> selectByExample(@RequestBody GoodsProductFullReductionExample example);

    @GetMapping(value = "/productFullReduction/selectByPrimaryKey")
    GoodsProductFullReduction selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/productFullReduction/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/productFullReduction/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/productFullReduction/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProductFullReduction record);

    @PostMapping(value = "/productFullReduction/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProductFullReduction record);

}
