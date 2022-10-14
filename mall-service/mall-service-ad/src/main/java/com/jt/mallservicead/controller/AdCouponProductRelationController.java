package com.jt.mallservicead.controller;

import com.jt.mallservicead.service.AdCouponProductRelationService;
import com.jt.model.AdCouponProductRelation;
import com.jt.model.AdCouponProductRelationExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 优惠券商品关联管理Controller
 */
@Controller
@Api(tags = "AdCouponProductRelationController", description = "优惠券商品关联管理")
@RequestMapping("/couponProductRelation")
public class AdCouponProductRelationController {
    @Autowired
    private AdCouponProductRelationService adCouponProductRelationService;

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody AdCouponProductRelationExample userMemberExample) {
        return adCouponProductRelationService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody AdCouponProductRelationExample example){
        return adCouponProductRelationService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return adCouponProductRelationService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody AdCouponProductRelation record){
        return adCouponProductRelationService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody AdCouponProductRelation record){
        return adCouponProductRelationService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<AdCouponProductRelation> selectByExample(@RequestBody AdCouponProductRelationExample example){
        return adCouponProductRelationService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    AdCouponProductRelation selectByPrimaryKey(@RequestParam("id") Long id){
        return adCouponProductRelationService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        AdCouponProductRelation record =(AdCouponProductRelation)map.get("AdCouponProductRelation");
        AdCouponProductRelationExample example = (AdCouponProductRelationExample)map.get("AdCouponProductRelationExample");
        return adCouponProductRelationService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        AdCouponProductRelation record =(AdCouponProductRelation)map.get("AdCouponProductRelation");
        AdCouponProductRelationExample example = (AdCouponProductRelationExample)map.get("AdCouponProductRelationExample");
        return adCouponProductRelationService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody AdCouponProductRelation record){
        return adCouponProductRelationService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody AdCouponProductRelation record){
        return adCouponProductRelationService.updateByPrimaryKey(record);
    }


}
