package com.jt.feign;

import com.jt.model.GoodsProductLadder;
import com.jt.model.GoodsProductLadderExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-goods")
public interface GoodsProductLadderFeign {

    @PostMapping(value = "/productLadder/countByExample")
    long countByExample(@RequestBody GoodsProductLadderExample example);

    @PostMapping(value = "/productLadder/deleteByExample")
    int deleteByExample(@RequestBody GoodsProductLadderExample example);

    @DeleteMapping(value = "/productLadder/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/productLadder/insert")
    int insert(@RequestBody GoodsProductLadder record);

    @PostMapping(value = "/productLadder/insertSelective")
    int insertSelective(@RequestBody GoodsProductLadder record);

    @PostMapping(value = "/productLadder/selectByExample")
    List<GoodsProductLadder> selectByExample(@RequestBody GoodsProductLadderExample example);

    @GetMapping(value = "/productLadder/selectByPrimaryKey")
    GoodsProductLadder selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/productLadder/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/productLadder/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/productLadder/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody GoodsProductLadder record);

    @PostMapping(value = "/productLadder/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody GoodsProductLadder record);

}
