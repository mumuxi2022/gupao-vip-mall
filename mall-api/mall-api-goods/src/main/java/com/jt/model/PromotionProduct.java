package com.jt.model;


import java.util.List;

/**
 * 促销商品信息，包括sku、打折优惠、满减优惠
 */
public class PromotionProduct extends GoodsProduct {
    //商品库存信息
    private List<GoodsSkuStock> skuStockList;
    //商品打折信息
    private List<GoodsProductLadder> productLadderList;
    //商品满减信息
    private List<GoodsProductFullReduction> productFullReductionList;

    public List<GoodsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<GoodsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<GoodsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<GoodsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<GoodsProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<GoodsProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }
}
