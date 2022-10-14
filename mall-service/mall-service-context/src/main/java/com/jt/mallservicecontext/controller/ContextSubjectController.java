package com.jt.mallservicecontext.controller;

import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicecontext.service.ContextSubjectService;
import com.jt.model.ContextSubject;
import com.jt.model.ContextSubjectExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品专题管理Controller
 */
@Controller
@Api(tags = "ContextSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class ContextSubjectController {
    @Autowired
    private ContextSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ContextSubject>> listAll() {
        List<ContextSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ContextSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<ContextSubject> subjectList = subjectService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

//    @ApiOperation(value = "获取推荐专题")
//    @RequestMapping(value = "/getRecommendBrandList", method = RequestMethod.GET)
//    @ResponseBody
//    List<ContextSubject> getRecommendSubjectList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
//        return subjectService.getRecommendSubjectList(offset,limit);
//    }
//
//    @ApiOperation(value = "不分页查询")
//    @RequestMapping(value = "/listByExample", method = RequestMethod.POST)
//    @ResponseBody
//    List<ContextSubject> listByExample(@RequestBody ContextSubjectExample contextSubjectExample){
//        return subjectService.listByExample(contextSubjectExample);
//    }

}
