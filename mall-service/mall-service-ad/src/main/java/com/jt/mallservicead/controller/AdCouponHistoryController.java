package com.jt.mallservicead.controller;

import com.jt.domain.AdCouponHistoryDetail;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicead.service.AdCouponHistoryService;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponExample;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponHistoryExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 优惠券领取记录管理Controller
 */
@Controller
@Api(tags = "AdCouponHistoryController", description = "优惠券领取记录管理")
@RequestMapping("/couponHistory")
public class AdCouponHistoryController {
    @Autowired
    private AdCouponHistoryService historyService;

    @ApiOperation("根据优惠券id，使用状态，订单编号分页获取领取记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<AdCouponHistory>> list(@RequestParam(value = "couponId", required = false) Long couponId,
                                                          @RequestParam(value = "useStatus", required = false) Integer useStatus,
                                                          @RequestParam(value = "orderSn", required = false) String orderSn,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<AdCouponHistory> historyList = historyService.list(couponId, useStatus, orderSn, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(historyList));
    }

    @ApiOperation(value = "通过Example统计")
    @RequestMapping(value = "/countByExample", method = RequestMethod.POST)
    @ResponseBody
    public Long countByExample(@RequestBody AdCouponHistoryExample userMemberExample) {
        return historyService.countByExample(userMemberExample);
    }

    @ApiOperation(value = "通过Example删除")
    @RequestMapping(value = "/deleteByExample", method = RequestMethod.POST)
    @ResponseBody
    int deleteByExample(@RequestBody AdCouponHistoryExample example){
        return historyService.deleteByExample(example);
    }

    @ApiOperation(value = "通过主键删除")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @ResponseBody
    int deleteByPrimaryKey(@RequestParam("id") Long id){
        return historyService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "插入")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    int insert(@RequestBody AdCouponHistory record){
        return historyService.insert(record);
    }

    @ApiOperation(value = "插入1")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    int insertSelective(@RequestBody AdCouponHistory record){
        return historyService.insertSelective(record);
    }

    @ApiOperation(value = "通过Example查询")
    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    @ResponseBody
    List<AdCouponHistory> selectByExample(@RequestBody AdCouponHistoryExample example){
        return historyService.selectByExample(example);
    }

    @ApiOperation(value = "通过主键查询")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    @ResponseBody
    AdCouponHistory selectByPrimaryKey(@RequestParam("id") Long id){
        return historyService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "更新")
    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map){
        AdCouponHistory record = (AdCouponHistory)map.get("AdCouponHistory");
        AdCouponHistoryExample example = (AdCouponHistoryExample)map.get("AdCouponHistoryExample");
        return historyService.updateByExampleSelective(record,example);
    }

    @ApiOperation(value = "通过Example更新")
    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    @ResponseBody
    int updateByExample(@RequestParam("map") Map<String,Object> map){
        AdCouponHistory record = (AdCouponHistory)map.get("AdCouponHistory");
        AdCouponHistoryExample example = (AdCouponHistoryExample)map.get("AdCouponHistoryExample");
        return historyService.updateByExample(record,example);
    }

    @ApiOperation(value = "通过主键更新1")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKeySelective(@RequestBody AdCouponHistory record){
        return historyService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "通过主键更新")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    int updateByPrimaryKey(@RequestBody AdCouponHistory record){
        return historyService.updateByPrimaryKey(record);
    }

    @ApiOperation(value = "查询详细列表")
    @RequestMapping(value = "/getDetailList", method = RequestMethod.GET)
    @ResponseBody
    List<AdCouponHistoryDetail> getDetailList(@RequestParam("memberId") Long memberId){
        return historyService.getDetailList(memberId);
    }

    @ApiOperation(value = "查询优惠券列表")
    @RequestMapping(value = "/getCouponList", method = RequestMethod.GET)
    @ResponseBody
    List<AdCoupon> getCouponList(@RequestParam("memberId") Long memberId, @RequestParam("useStatus") Integer useStatus){
        return historyService.getCouponList(memberId,useStatus);
    }
}
