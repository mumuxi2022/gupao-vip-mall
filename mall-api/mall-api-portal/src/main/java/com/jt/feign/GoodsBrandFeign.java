package com.jt.feign;

import com.jt.dto.FlashPromotionProduct;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsBrandExample;
import com.jt.model.GoodsProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:40
 */
@FeignClient("mall-service-goods")
public interface GoodsBrandFeign {
    /**
     * 获取推荐品牌
     */
    @GetMapping(value = "/brand/getRecommendBrandList")
    List<GoodsBrand> getRecommendBrandList(@RequestParam("offset") Integer offset,@RequestParam("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    @GetMapping(value = "/brand/getFlashProductList")
    List<FlashPromotionProduct> getFlashProductList(@RequestParam("flashPromotionId") Long flashPromotionId, @RequestParam("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    @GetMapping(value = "/product/getNewProductList")
    List<GoodsProduct> getNewProductList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    @GetMapping(value = "/product/getHotProductList")
    List<GoodsProduct> getHotProductList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

    @PostMapping(value = "/brand/countByExample")
    long countByExample(@RequestBody GoodsBrandExample example);

    @PostMapping(value = "/brand/deleteByExample")
    int deleteByExample(@RequestBody GoodsBrandExample example);

    @DeleteMapping(value = "/brand/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/brand/insert")
    int insert(@RequestBody GoodsBrand record);

    @PostMapping(value = "/brand/insertSelective")
    int insertSelective(@RequestBody GoodsBrand record);

    @PostMapping(value = "/brand/selectByExample")
    List<GoodsBrand> selectByExample(@RequestBody GoodsBrandExample example);

    @GetMapping(value = "/brand/selectByPrimaryKey")
    GoodsBrand selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/brand/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/brand/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/brand/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsBrand record);

    @PostMapping(value = "/brand/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsBrand record);
}
