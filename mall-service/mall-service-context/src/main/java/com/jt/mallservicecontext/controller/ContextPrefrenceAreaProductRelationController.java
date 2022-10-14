package com.jt.mallservicecontext.controller;

import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicecontext.service.ContextPrefrenceAreaProductRelationService;
import com.jt.mallservicecontext.service.ContextPrefrenceAreaService;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;
import com.jt.model.ContextSubjectProductRelationExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品优选管理Controller
 */
@Controller
@Api(tags = "ContextPrefrenceAreaProductRelationController", description = "优选专区和产品关系管理")
@RequestMapping("/prefrenceAreaProductRelation")
public class ContextPrefrenceAreaProductRelationController {
    @Autowired
    private ContextPrefrenceAreaProductRelationService contextPrefrenceAreaProductRelationService;

    @ApiOperation("批量创建")
    @RequestMapping(value = "/insertList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> insertList(@RequestBody List<ContextPrefrenceAreaProductRelation> dataList) {
        int a = contextPrefrenceAreaProductRelationService.insertList(dataList);
        return CommonResult.success(a);
    }

    @ApiOperation("删除指定信息")
    @RequestMapping(value = "/deleteByExample",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> deleteByExample(@RequestBody ContextPrefrenceAreaProductRelationExample subjectProductRelationExample) {
        int count = contextPrefrenceAreaProductRelationService.deleteByExample(subjectProductRelationExample);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据商品id查询关系")
    @RequestMapping(value = "/getListByProductId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ContextPrefrenceAreaProductRelation>> getListByProductId(@RequestParam("productId") Long productId) {
        List<ContextPrefrenceAreaProductRelation> list = contextPrefrenceAreaProductRelationService.getListByProductId(productId);
        return CommonResult.success(list);
    }
}
