package com.jt.feign;

import com.jt.dto.FlashPromotionProduct;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductFeign {
    @PostMapping(value = "/product/listByExample")
    List<GoodsProduct> listByExample(@RequestBody GoodsProductExample goodsProductExample);

    @GetMapping(value = "/product/listByIds")
    List<GoodsProduct> listByIds(@RequestParam("ids") List<Long> ids);

    @PostMapping(value = "/product/countByExample")
    long countByExample(@RequestBody GoodsProductExample example);

    @PostMapping(value = "/product/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductExample example);

    @DeleteMapping(value = "/product/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/product/insert")
    int insert(@RequestBody GoodsProduct record);

    @PostMapping(value = "/product/insertSelective")
    int insertSelective(@RequestBody GoodsProduct record);

    @PostMapping(value = "/product/selectByExampleWithBLOBs")
    List<GoodsProduct> selectByExampleWithBLOBs(@RequestBody GoodsProductExample example);

    @PostMapping(value = "/product/selectByExample")
    List<GoodsProduct> selectByExample(@RequestBody GoodsProductExample example);

    @GetMapping(value = "/product/selectByPrimaryKey")
    GoodsProduct selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/product/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/product/updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/product/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/product/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProduct record);

    @PostMapping(value = "/product/updateByPrimaryKeyWithBLOBs")
    int updateByPrimaryKeyWithBLOBs(@RequestBody GoodsProduct record);

    @PostMapping(value = "/product/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProduct record);
}
