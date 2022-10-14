package com.jt.mallservicegoods.controller;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsProductParam;
import com.jt.dto.GoodsProductQueryParam;
import com.jt.dto.GoodsProductResult;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicegoods.service.GoodsProductService;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品管理Controller
 */
@Controller
@Api(tags = "GoodsProductController", description = "商品管理")
@RequestMapping("/product")
public class GoodsProductController {
    @Autowired
    private GoodsProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody GoodsProductParam productParam) {
        int count = productService.create(productParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<GoodsProductResult> getUpdateInfo(@PathVariable Long id) {
        GoodsProductResult productResult = productService.getUpdateInfo(id);
        return CommonResult.success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody GoodsProductParam productParam) {
        int count = productService.update(id, productParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GoodsProduct>> getList(GoodsProductQueryParam productQueryParam,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<GoodsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<GoodsProduct>> getList(String keyword) {
        List<GoodsProduct> productList = productService.list(keyword);
        return CommonResult.success(productList);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("verifyStatus") Integer verifyStatus,
                                           @RequestParam("detail") String detail) {
        int count = productService.updateVerifyStatus(ids, verifyStatus, detail);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("publishStatus") Integer publishStatus) {
        int count = productService.updatePublishStatus(ids, publishStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus) {
        int count = productService.updateNewStatus(ids, newStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                           @RequestParam("deleteStatus") Integer deleteStatus) {
        int count = productService.updateDeleteStatus(ids, deleteStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 获取新品推荐
     */
    @ApiOperation(value = "获取新品推荐")
    @RequestMapping(value = "/getNewProductList", method = RequestMethod.GET)
    @ResponseBody
    List<GoodsProduct> getNewProductList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return productService.getNewProductList(offset,limit);
    }
    /**
     * 获取人气推荐
     */
    @ApiOperation(value = "获取人气推荐")
    @RequestMapping(value = "/getHotProductList", method = RequestMethod.GET)
    @ResponseBody
    List<GoodsProduct> getHotProductList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return productService.getHotProductList(offset,limit);
    }

    @ApiOperation(value = "不分页查询")
    @RequestMapping(value = "/listByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProduct> listByExample(@RequestBody GoodsProductExample goodsProductExample){
        return productService.listByExample(goodsProductExample);
    }

    @ApiOperation(value = "根据ids查询")
    @RequestMapping(value = "/listByIds", method = RequestMethod.GET)
    @ResponseBody
    List<GoodsProduct> listByIds(@RequestParam List<Long> ids){
        return productService.listByIds(ids);
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    long countByExample(@RequestBody GoodsProductExample example){
        return productService.countByExample(example);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsProductExample example){
        return productService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return productService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsProduct record){
        return productService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsProduct record){
        return productService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询1")
    @RequestMapping(value = "/selectByExampleWithBLOBs", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProduct> selectByExampleWithBLOBs(@RequestBody GoodsProductExample example){
        return productService.selectByExampleWithBLOBs(example);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsProduct> selectByExample(@RequestBody GoodsProductExample example){
        return productService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsProduct selectByPrimaryKey(@RequestParam("id") Long id){
        return productService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsProduct record =(GoodsProduct)map.get("GoodsProduct");
        GoodsProductExample example = (GoodsProductExample)map.get("GoodsProductExample");
        return productService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "更新1")
    @RequestMapping(value = "/updateByExampleWithBLOBs", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleWithBLOBs(@RequestParam("map") Map<String,Object> map){
        GoodsProduct record =(GoodsProduct)map.get("GoodsProduct");
        GoodsProductExample example = (GoodsProductExample)map.get("GoodsProductExample");
        return productService.updateByExampleWithBLOBs(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsProduct record =(GoodsProduct)map.get("GoodsProduct");
        GoodsProductExample example = (GoodsProductExample)map.get("GoodsProductExample");
        return productService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsProduct record){
        return productService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeyWithBLOBs", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeyWithBLOBs(@RequestBody GoodsProduct record){
        return productService.updateByPrimaryKeyWithBLOBs(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsProduct record){
        return productService.updateByPrimaryKey(record);
    }
}
