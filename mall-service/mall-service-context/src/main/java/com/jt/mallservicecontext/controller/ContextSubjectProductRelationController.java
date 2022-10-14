package com.jt.mallservicecontext.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicecontext.service.ContextSubjectProductRelationService;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextSubjectProductRelation;
import com.jt.model.ContextSubjectProductRelationExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专题商品关系Controller
 */
@Controller
@Api(tags = "ContextSubjectProductRelationController", description = "专题商品关系管理")
@RequestMapping("/subjectProductRelation")
public class ContextSubjectProductRelationController {
    @Autowired
    private ContextSubjectProductRelationService contextSubjectProductRelationService;

    @ApiOperation("批量创建")
    @RequestMapping(value = "/insertList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> insertList(@RequestBody List<ContextSubjectProductRelation> dataList) {
        int count = contextSubjectProductRelationService.insertList(dataList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定信息")
    @RequestMapping(value = "/deleteByExample",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> deleteByExample(@RequestBody ContextSubjectProductRelationExample subjectProductRelationExample) {
        int count = contextSubjectProductRelationService.deleteByExample(subjectProductRelationExample);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据商品id查询关系")
    @RequestMapping(value = "/getListByProductId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ContextSubjectProductRelation>> getListByProductId(@RequestParam("productId") Long productId) {
        List<ContextSubjectProductRelation> list = contextSubjectProductRelationService.getListByProductId(productId);
        return CommonResult.success(list);
    }
}
