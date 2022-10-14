package com.jt.mallservicead.controller;

import com.jt.mallservicead.service.AdCouponProductCategoryRelationService;
import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductCategoryRelationExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 优惠券商品分类关联管理Controller
 */
@Controller
@Api(tags = "AdCouponProductCategoryRelationController", description = "优惠券商品分类关联管理")
@RequestMapping("/couponProductCategoryRelation")
public class AdCouponProductCategoryRelationController {
    @Autowired
    private AdCouponProductCategoryRelationService adCouponProductCategoryRelationService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody AdCouponProductCategoryRelationExample userMemberExample) {
        return adCouponProductCategoryRelationService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody AdCouponProductCategoryRelationExample example){
        return adCouponProductCategoryRelationService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return adCouponProductCategoryRelationService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody AdCouponProductCategoryRelation record){
        return adCouponProductCategoryRelationService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody AdCouponProductCategoryRelation record){
        return adCouponProductCategoryRelationService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<AdCouponProductCategoryRelation> selectByExample(@RequestBody AdCouponProductCategoryRelationExample example){
        return adCouponProductCategoryRelationService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    AdCouponProductCategoryRelation selectByPrimaryKey(@RequestParam("id") Long id){
        return adCouponProductCategoryRelationService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        AdCouponProductCategoryRelation record = (AdCouponProductCategoryRelation)map.get("AdCouponProductCategoryRelation");
        AdCouponProductCategoryRelationExample example = (AdCouponProductCategoryRelationExample)map.get("AdCouponProductCategoryRelationExample");
        return adCouponProductCategoryRelationService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        AdCouponProductCategoryRelation record = (AdCouponProductCategoryRelation)map.get("AdCouponProductCategoryRelation");
        AdCouponProductCategoryRelationExample example = (AdCouponProductCategoryRelationExample)map.get("AdCouponProductCategoryRelationExample");
        return adCouponProductCategoryRelationService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody AdCouponProductCategoryRelation record){
        return adCouponProductCategoryRelationService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody AdCouponProductCategoryRelation record){
        return adCouponProductCategoryRelationService.updateByPrimaryKey(record);
    }


}
