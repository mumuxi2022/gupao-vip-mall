package com.jt.feign;

import com.jt.model.GoodsProductCategory;
import com.jt.model.GoodsProductCategoryExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductCategoryFeign {
    @PostMapping(value = "/productCategory/listByExample")
    List<GoodsProductCategory> listByExample(@RequestBody GoodsProductCategoryExample goodsProductCategoryExample);

    @PostMapping(value = "/productCategory/countByExample")
    long countByExample(@RequestBody GoodsProductCategoryExample example);

    @DeleteMapping(value = "/productCategory/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductCategoryExample example);

    @DeleteMapping(value = "/productCategory/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/productCategory/insert")
    int insert(@RequestBody GoodsProductCategory record);

    @PostMapping(value = "/productCategory/insertSelective")
    int insertSelective(@RequestBody GoodsProductCategory record);

    @PostMapping(value = "/productCategory/selectByExample")
    List<GoodsProductCategory> selectByExample(@RequestBody GoodsProductCategoryExample example);

    @GetMapping(value = "/productCategory/selectByPrimaryKey")
    GoodsProductCategory selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/productCategory/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/productCategory/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/productCategory/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProductCategory record);

    @PostMapping(value = "/productCategory/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProductCategory record);
}
