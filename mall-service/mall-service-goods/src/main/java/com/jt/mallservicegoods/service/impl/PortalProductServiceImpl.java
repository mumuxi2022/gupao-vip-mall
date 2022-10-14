package com.jt.mallservicegoods.service.impl;

import com.jt.mallservicegoods.mapper.GoodsSkuStockMapper;
import com.jt.mallservicegoods.mapper.PortalProductMapper;
import com.jt.mallservicegoods.service.GoodsSkuStockService;
import com.jt.mallservicegoods.service.PortalProductService;
import com.jt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品sku库存管理Service实现类
 */
@Service
public class PortalProductServiceImpl implements PortalProductService {
    @Autowired
    private PortalProductMapper portalProductMapper;

    @Override
    public CartProduct getCartProduct(Long id) {
        return portalProductMapper.getCartProduct(id);
    }

    @Override
    public List<PromotionProduct> getPromotionProductList(List<Long> ids) {
        return portalProductMapper.getPromotionProductList(ids);
    }

    @Override
    public int updateSkuStock(List<OrderItem> orderItemList) {
        return portalProductMapper.updateSkuStock(orderItemList);
    }

    @Override
    public int releaseSkuStockLock(List<OrderItem> orderItemList) {
        return portalProductMapper.releaseSkuStockLock(orderItemList);
    }
}
