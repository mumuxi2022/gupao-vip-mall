package com.jt.mallservicegoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsBrandParam;
import com.jt.feign.AdFlashPromotionProductRelationFeign;
import com.jt.feign.AdHomeBrandFeign;
import com.jt.mallservicegoods.mapper.GoodsBrandMapper;
import com.jt.mallservicegoods.mapper.GoodsProductMapper;
import com.jt.mallservicegoods.service.GoodsBrandService;
import com.jt.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品品牌Service实现类
 */
@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {
    @Autowired
    private GoodsBrandMapper brandMapper;
    @Autowired
    private GoodsProductMapper productMapper;
    @Autowired
    private AdHomeBrandFeign adHomeAdvertiseFeign;
    @Autowired
    private AdFlashPromotionProductRelationFeign adFlashPromotionProductRelationFeign;

    @Override
    public List<GoodsBrand> listAllBrand() {
        return brandMapper.selectByExample(new GoodsBrandExample());
    }

    @Override
    public int createBrand(GoodsBrandParam goodsBrandParam) {
        GoodsBrand goodsBrand = new GoodsBrand();
        BeanUtils.copyProperties(goodsBrandParam, goodsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(goodsBrand.getFirstLetter())) {
            goodsBrand.setFirstLetter(goodsBrand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(goodsBrand);
    }

    @Override
    public int updateBrand(Long id, GoodsBrandParam goodsBrandParam) {
        GoodsBrand goodsBrand = new GoodsBrand();
        BeanUtils.copyProperties(goodsBrandParam, goodsBrand);
        goodsBrand.setId(id);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(goodsBrand.getFirstLetter())) {
            goodsBrand.setFirstLetter(goodsBrand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        GoodsProduct product = new GoodsProduct();
        product.setBrandName(goodsBrand.getName());
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andBrandIdEqualTo(id);
        productMapper.updateByExampleSelective(product,example);
        return brandMapper.updateByPrimaryKeySelective(goodsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        goodsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(goodsBrandExample);
    }

    @Override
    public List<GoodsBrand> listBrand(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        goodsBrandExample.setOrderByClause("sort desc");
        GoodsBrandExample.Criteria criteria = goodsBrandExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return brandMapper.selectByExample(goodsBrandExample);
    }

    @Override
    public GoodsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setShowStatus(showStatus);
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        goodsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(goodsBrand, goodsBrandExample);
    }

    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setFactoryStatus(factoryStatus);
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        goodsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(goodsBrand, goodsBrandExample);
    }

    /**
     * 获取推荐品牌
     */
    @Override
    public List<GoodsBrand> getRecommendBrandList(Integer offset, Integer limit){
        List<AdHomeBrand> list = adHomeAdvertiseFeign.listAll();
        List<Long> idList = new ArrayList<>();
        for(AdHomeBrand adHomeBrand : list){
            idList.add(adHomeBrand.getBrandId());
        }
        return brandMapper.getRecommendBrandList(idList,offset,limit);

    }

    /**
     * 获取秒杀商品
     */
    @Override
    public List<FlashPromotionProduct> getFlashProductList(Long flashPromotionId, Long sessionId){
        List<AdFlashPromotionProductRelation> list = adFlashPromotionProductRelationFeign.listBySomeId(flashPromotionId,sessionId);
        List<Long> idList = new ArrayList<>();
        for(AdFlashPromotionProductRelation adFlashPromotionProductRelation : list){
            idList.add(adFlashPromotionProductRelation.getProductId());
        }
        List<FlashPromotionProduct> goodsProductList = productMapper.getFlashProductList(idList);
        for(AdFlashPromotionProductRelation adFlashPromotionProductRelation : list){
            for(FlashPromotionProduct flashPromotionProduct : goodsProductList){
                if(adFlashPromotionProductRelation.getProductId().equals(flashPromotionProduct.getId())){
                    flashPromotionProduct.setFlashPromotionPrice(adFlashPromotionProductRelation.getFlashPromotionPrice());
                    flashPromotionProduct.setFlashPromotionCount(adFlashPromotionProductRelation.getFlashPromotionCount());
                    flashPromotionProduct.setFlashPromotionLimit(adFlashPromotionProductRelation.getFlashPromotionLimit());
                    break;
                }
            }
        }
        return goodsProductList;
    }

    @Override
    public long countByExample(GoodsBrandExample example) {
        return brandMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsBrandExample example) {
        return brandMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsBrand record) {
        return brandMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsBrand record) {
        return brandMapper.insertSelective(record);
    }

    @Override
    public List<GoodsBrand> selectByExample(GoodsBrandExample example) {
        return brandMapper.selectByExample(example);
    }

    @Override
    public GoodsBrand selectByPrimaryKey(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsBrand record, GoodsBrandExample example) {
        return brandMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(GoodsBrand record, GoodsBrandExample example) {
        return brandMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsBrand record) {
        return brandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsBrand record) {
        return brandMapper.updateByPrimaryKey(record);
    }


}
