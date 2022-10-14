package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.AdFlashPromotionProduct;
import com.jt.dto.FlashPromotionProduct;
import com.jt.feign.GoodsProductFeign;
import com.jt.mallservicead.mapper.AdFlashPromotionProductRelationMapper;
import com.jt.mallservicead.service.AdFlashPromotionProductRelationService;
import com.jt.model.AdFlashPromotionProductRelation;
import com.jt.model.AdFlashPromotionProductRelationExample;
import com.jt.model.GoodsProduct;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 限时购商品关联管理Service实现类
 */
@Service
public class AdFlashPromotionProductRelationServiceImpl implements AdFlashPromotionProductRelationService {
    @Autowired
    private AdFlashPromotionProductRelationMapper relationMapper;

    @Autowired
    private GoodsProductFeign goodsProductFeign;

    @Override
    public int create(List<AdFlashPromotionProductRelation> relationList) {
        for (AdFlashPromotionProductRelation relation : relationList) {
            relationMapper.insert(relation);
        }
        return relationList.size();
    }

    @Override
    public int update(Long id, AdFlashPromotionProductRelation relation) {
        relation.setId(id);
        return relationMapper.updateByPrimaryKey(relation);
    }

    @Override
    public int delete(Long id) {
        return relationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public AdFlashPromotionProductRelation getItem(Long id) {
        return relationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<AdFlashPromotionProductRelation> list = relationMapper.getList(flashPromotionId,flashPromotionSessionId);
        List<Long> ids = new ArrayList<>();
        for(AdFlashPromotionProductRelation adFlashPromotionProductRelation : list){
            ids.add(adFlashPromotionProductRelation.getProductId());
        }
        List<GoodsProduct> listGoods = goodsProductFeign.listByIds(ids);
        List<AdFlashPromotionProduct> rest = new ArrayList<>();
        for(GoodsProduct goods : listGoods){
            for(AdFlashPromotionProductRelation adf : list){
                if(adf.getProductId().equals(goods.getId())){
                    AdFlashPromotionProduct ad = new AdFlashPromotionProduct();
                    ad.setId(adf.getId());
                    ad.setFlashPromotionPrice(adf.getFlashPromotionPrice());
                    ad.setFlashPromotionCount(adf.getFlashPromotionCount());
                    ad.setFlashPromotionLimit(adf.getFlashPromotionLimit());
                    ad.setFlashPromotionId(adf.getFlashPromotionId());
                    ad.setFlashPromotionSessionId(adf.getFlashPromotionSessionId());
                    ad.setProductId(adf.getProductId());
                    ad.setSort(adf.getSort());
                    ad.setProduct(goods);
                    rest.add(ad);
                    break;
                }
            }
        }
        return rest;
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        AdFlashPromotionProductRelationExample example = new AdFlashPromotionProductRelationExample();
        example.createCriteria()
                .andFlashPromotionIdEqualTo(flashPromotionId)
                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        return relationMapper.countByExample(example);
    }

    @Override
    public List<AdFlashPromotionProductRelation> listBySomeId(Long flashPromotionId,Long sessionId) {
        return relationMapper.listBySomeId(flashPromotionId,sessionId);
    }
}
