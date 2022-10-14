package com.jt.mallserviceportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.feign.GoodsBrandFeign;
import com.jt.feign.GoodsProductFeign;
import com.jt.mallcommon.api.CommonPage;
import com.jt.mallserviceportal.service.PortalBrandService;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前台品牌管理Service实现类
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private GoodsBrandFeign goodsBrandFeign;
    @Autowired
    private GoodsProductFeign productMapper;

    @Override
    public List<GoodsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return goodsBrandFeign.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public GoodsBrand detail(Long brandId) {
        return goodsBrandFeign.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<GoodsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<GoodsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
