package com.jt.mallserviceportal.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.jt.domain.GoodsPortalProductDetail;
import com.jt.domain.GoodsProductCategoryNode;
import com.jt.feign.*;
import com.jt.mallserviceportal.service.GoodsPortalProductService;
import com.jt.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 前台订单管理Service实现类
 */
@Service
public class GoodsPortalProductServiceImpl implements GoodsPortalProductService {
    @Autowired
    private GoodsProductFeign productMapper;
    @Autowired
    private GoodsProductCategoryFeign productCategoryMapper;
    @Autowired
    private GoodsBrandFeign brandMapper;
    @Autowired
    private GoodsProductAttributeFeign productAttributeMapper;
    @Autowired
    private GoodsProductAttributeValueFeign productAttributeValueMapper;
    @Autowired
    private GoodsSkuStockFeign skuStockMapper;
    @Autowired
    private GoodsProductLadderFeign productLadderMapper;
    @Autowired
    private GoodsProductFullReductionFeign productFullReductionMapper;
    @Autowired
    private AdCouponFeign portalProductDao;

    @Override
    public List<GoodsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsProductExample example = new GoodsProductExample();
        GoodsProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (StrUtil.isNotEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (brandId != null) {
            criteria.andBrandIdEqualTo(brandId);
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        //1->按新品；2->按销量；3->价格从低到高；4->价格从高到低
        if (sort == 1) {
            example.setOrderByClause("id desc");
        } else if (sort == 2) {
            example.setOrderByClause("sale desc");
        } else if (sort == 3) {
            example.setOrderByClause("price asc");
        } else if (sort == 4) {
            example.setOrderByClause("price desc");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public List<GoodsProductCategoryNode> categoryTreeList() {
        GoodsProductCategoryExample example = new GoodsProductCategoryExample();
        List<GoodsProductCategory> allList = productCategoryMapper.selectByExample(example);
        List<GoodsProductCategoryNode> result = allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public GoodsPortalProductDetail detail(Long id) {
        GoodsPortalProductDetail result = new GoodsPortalProductDetail();
        //获取商品信息
        GoodsProduct product = productMapper.selectByPrimaryKey(id);
        result.setProduct(product);
        //获取品牌信息
        GoodsBrand brand = brandMapper.selectByPrimaryKey(product.getBrandId());
        result.setBrand(brand);
        //获取商品属性信息
        GoodsProductAttributeExample attributeExample = new GoodsProductAttributeExample();
        attributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(product.getProductAttributeCategoryId());
        List<GoodsProductAttribute> productAttributeList = productAttributeMapper.selectByExample(attributeExample);
        result.setProductAttributeList(productAttributeList);
        //获取商品属性值信息
        if(CollUtil.isNotEmpty(productAttributeList)){
            List<Long> attributeIds = productAttributeList.stream().map(GoodsProductAttribute::getId).collect(Collectors.toList());
            GoodsProductAttributeValueExample attributeValueExample = new GoodsProductAttributeValueExample();
            attributeValueExample.createCriteria().andProductIdEqualTo(product.getId())
                    .andProductAttributeIdIn(attributeIds);
            List<GoodsProductAttributeValue> productAttributeValueList = productAttributeValueMapper.selectByExample(attributeValueExample);
            result.setProductAttributeValueList(productAttributeValueList);
        }
        //获取商品SKU库存信息
        GoodsSkuStockExample skuExample = new GoodsSkuStockExample();
        skuExample.createCriteria().andProductIdEqualTo(product.getId());
        List<GoodsSkuStock> skuStockList = skuStockMapper.selectByExample(skuExample);
        result.setSkuStockList(skuStockList);
        //商品阶梯价格设置
        if(product.getPromotionType()==3){
            GoodsProductLadderExample ladderExample = new GoodsProductLadderExample();
            ladderExample.createCriteria().andProductIdEqualTo(product.getId());
            List<GoodsProductLadder> productLadderList = productLadderMapper.selectByExample(ladderExample);
            result.setProductLadderList(productLadderList);
        }
        //商品满减价格设置
        if(product.getPromotionType()==4){
            GoodsProductFullReductionExample fullReductionExample = new GoodsProductFullReductionExample();
            fullReductionExample.createCriteria().andProductIdEqualTo(product.getId());
            List<GoodsProductFullReduction> productFullReductionList = productFullReductionMapper.selectByExample(fullReductionExample);
            result.setProductFullReductionList(productFullReductionList);
        }
        //商品可用优惠券
        result.setCouponList(portalProductDao.getAvailableCouponList(product.getId(),product.getProductCategoryId()));
        return result;
    }


    /**
     * 初始对象转化为节点对象
     */
    private GoodsProductCategoryNode covert(GoodsProductCategory item, List<GoodsProductCategory> allList) {
        GoodsProductCategoryNode node = new GoodsProductCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<GoodsProductCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
