package com.jt.mallservicegoods.controller;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsBrandParam;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicegoods.service.GoodsBrandService;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsBrandExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 品牌功能Controller
 */
@Controller
@Api(tags = "GoodsBrandController", description = "商品品牌管理")
@RequestMapping("/brand")
public class GoodsBrandController {
    @Autowired
    private GoodsBrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<GoodsBrand>> getList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody GoodsBrandParam goodsBrand) {
        CommonResult commonResult;
        int count = brandService.createBrand(goodsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,
                               @Validated @RequestBody GoodsBrandParam goodsBrandParam) {
        CommonResult commonResult;
        int count = brandService.updateBrand(id, goodsBrandParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GoodsBrand>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<GoodsBrand> brandList = brandService.listBrand(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<GoodsBrand> getItem(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation(value = "批量删除品牌")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteBatch(@RequestParam("ids") List<Long> ids) {
        int count = brandService.deleteBrand(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "批量更新显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("showStatus") Integer showStatus) {
        int count = brandService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("factoryStatus") Integer factoryStatus) {
        int count = brandService.updateFactoryStatus(ids, factoryStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 获取推荐品牌
     */
    @ApiOperation(value = "获取推荐品牌")
    @RequestMapping(value = "/getRecommendBrandList", method = RequestMethod.GET)
    @ResponseBody
    List<GoodsBrand> getRecommendBrandList(@RequestParam("offset") Integer offset,@RequestParam("limit") Integer limit){
        return brandService.getRecommendBrandList(offset,limit);
    }

    /**
     * 获取秒杀商品
     */
    @ApiOperation(value = "获取秒杀商品")
    @RequestMapping(value = "/getFlashProductList", method = RequestMethod.GET)
    @ResponseBody
    List<FlashPromotionProduct> getFlashProductList(@RequestParam("flashPromotionId") Long flashPromotionId, @RequestParam("sessionId") Long sessionId){
        return brandService.getFlashProductList(flashPromotionId,sessionId);
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody GoodsBrandExample userMemberExample) {
        return brandService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody GoodsBrandExample example){
        return brandService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return brandService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody GoodsBrand record){
        return brandService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody GoodsBrand record){
        return brandService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<GoodsBrand> selectByExample(@RequestBody GoodsBrandExample example){
        return brandService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    GoodsBrand selectByPrimaryKey(@RequestParam("id") Long id){
        return brandService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        GoodsBrand record = (GoodsBrand)map.get("GoodsBrand");
        GoodsBrandExample example = (GoodsBrandExample)map.get("GoodsBrandExample");
        return brandService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        GoodsBrand record = (GoodsBrand)map.get("GoodsBrand");
        GoodsBrandExample example = (GoodsBrandExample)map.get("GoodsBrandExample");
        return brandService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody GoodsBrand record){
        return brandService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody GoodsBrand record){
        return brandService.updateByPrimaryKey(record);
    }

}
