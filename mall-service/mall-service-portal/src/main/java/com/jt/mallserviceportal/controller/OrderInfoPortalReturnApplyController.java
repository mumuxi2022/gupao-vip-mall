package com.jt.mallserviceportal.controller;

import com.jt.domain.OrderReturnApplyParam;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallserviceportal.service.OrderInfoPortalReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 申请退货管理Controller
 */
@Controller
@Api(tags = "OrderInfoPortalReturnApplyController", description = "申请退货管理")
@RequestMapping("/returnApply")
public class OrderInfoPortalReturnApplyController {
    @Autowired
    private OrderInfoPortalReturnApplyService returnApplyService;

    @ApiOperation("申请退货")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody OrderReturnApplyParam returnApply) {
        int count = returnApplyService.create(returnApply);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
