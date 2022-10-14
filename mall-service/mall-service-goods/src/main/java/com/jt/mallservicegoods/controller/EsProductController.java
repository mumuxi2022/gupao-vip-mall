package com.jt.mallservicegoods.controller;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsBrandParam;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallcommon.api.CommonResult;
import com.jt.mallservicegoods.service.EsProductService;
import com.jt.mallservicegoods.service.GoodsBrandService;
import com.jt.model.EsProduct;
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
 * 搜索商品管理自定义Controller
 */
@Controller
@Api(tags = "EsProductController", description = "ES商品管理")
@RequestMapping("/esproduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "获取指定ID的搜索商品")
    @RequestMapping(value = "/getAllEsProductList", method = RequestMethod.GET)
    @ResponseBody
    public List<EsProduct> getAllEsProductList(@RequestParam("id") Long id){
        if(id==-1){
            id = null;
        }
        return esProductService.getAllEsProductList(id);
    }
}
