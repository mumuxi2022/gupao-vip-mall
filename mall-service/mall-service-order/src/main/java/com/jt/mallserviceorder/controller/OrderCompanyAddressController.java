package com.jt.mallserviceorder.controller;

import com.jt.mallcommon.api.CommonResult;
import com.jt.mallserviceorder.service.OrderCompanyAddressService;
import com.jt.model.OrderCompanyAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 收货地址管理Controller
 */
@Controller
@Api(tags = "OrderCompanyAddressController", description = "收货地址管理")
@RequestMapping("/companyAddress")
public class OrderCompanyAddressController {
    @Autowired
    private OrderCompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OrderCompanyAddress>> list() {
        List<OrderCompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }
}
