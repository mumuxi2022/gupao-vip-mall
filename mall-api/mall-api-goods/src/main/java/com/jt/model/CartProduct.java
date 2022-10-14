package com.jt.model;


import java.util.List;

/**
 * 购物车中带规格和SKU的商品信息
 */
public class CartProduct extends GoodsProduct {
    //商品属性列表
    private List<GoodsProductAttribute> productAttributeList;
    //商品SKU库存列表
    private List<GoodsSkuStock> skuStockList;

    public List<GoodsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<GoodsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<GoodsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<GoodsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }
}
