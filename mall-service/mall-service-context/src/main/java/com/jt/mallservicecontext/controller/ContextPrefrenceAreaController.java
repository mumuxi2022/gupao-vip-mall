package com.jt.mallservicecontext.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicecontext.service.ContextPrefrenceAreaService;
import com.jt.model.ContextPrefrenceArea;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品优选管理Controller
 */
@Controller
@Api(tags = "ContextPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class ContextPrefrenceAreaController {
    @Autowired
    private ContextPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ContextPrefrenceArea>> listAll() {
        List<ContextPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }
}
