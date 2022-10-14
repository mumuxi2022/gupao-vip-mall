package com.jt.mallservicegoods.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicegoods.service.GoodsSkuStockService;
import com.jt.model.GoodsSkuStock;
import com.jt.model.GoodsSkuStockExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * sku库存Controller
 */
@Controller
@Api(tags = "GoodsSkuStockController", description = "sku商品库存管理")
@RequestMapping("/sku")
public class GoodsSkuStockController {
    @Autowired
    private GoodsSkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<GoodsSkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<GoodsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }
    @ApiOperation("批量更新库存信息")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long pid, @RequestBody List<GoodsSkuStock> skuStockList){
        int count = skuStockService.update(pid,skuStockList);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody GoodsSkuStockExample userMemberExample) {
        return skuStockService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsSkuStockExample example){
        return skuStockService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return skuStockService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsSkuStock record){
        return skuStockService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsSkuStock record){
        return skuStockService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsSkuStock> selectByExample(@RequestBody GoodsSkuStockExample example){
        return skuStockService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsSkuStock selectByPrimaryKey(@RequestParam("id") Long id){
        return skuStockService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsSkuStock record = (GoodsSkuStock)map.get("GoodsSkuStock");
        GoodsSkuStockExample example = (GoodsSkuStockExample)map.get("GoodsSkuStockExample");
        return skuStockService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsSkuStock record = (GoodsSkuStock)map.get("GoodsSkuStock");
        GoodsSkuStockExample example = (GoodsSkuStockExample)map.get("GoodsSkuStockExample");
        return skuStockService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsSkuStock record){
        return skuStockService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsSkuStock record){
        return skuStockService.updateByPrimaryKey(record);
    }
}
