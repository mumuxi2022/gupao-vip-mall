package com.jt.mallserviceportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.domain.HomeContentResult;
import com.jt.domain.HomeFlashPromotion;
import com.jt.dto.FlashPromotionProduct;
import com.jt.feign.*;
import com.jt.mallserviceportal.service.HomeService;
import com.jt.mallserviceportal.util.DateUtil;
import com.jt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 首页内容管理Service实现类
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private AdHomeAdvertiseFeign adHomeAdvertiseFeign;
    @Autowired
    private GoodsBrandFeign goodsBrandFeign;
    @Autowired
    private ContextSubjectFeign contextSubjectFeign;
    @Autowired
    private AdFlashPromotionFeign adFlashPromotionFeign;
    @Autowired
    private AdFlashPromotionSessionFeign adFlashPromotionSessionFeign;
    @Autowired
    private GoodsProductFeign  goodsProductFeign;
    @Autowired
    private GoodsProductCategoryFeign goodsProductCategoryFeign;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        result.setBrandList(goodsBrandFeign.getRecommendBrandList(0,6));
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
        result.setNewProductList(goodsBrandFeign.getNewProductList(0,4));
        //获取人气推荐
        result.setHotProductList(goodsBrandFeign.getHotProductList(0,4));
        //获取推荐专题
        result.setSubjectList(contextSubjectFeign.getRecommendSubjectList(0,4));
        return result;
    }

    @Override
    public List<GoodsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        // TODO: 2019/1/29 暂时默认推荐所有商品
        PageHelper.startPage(pageNum,pageSize);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria()
                .andDeleteStatusEqualTo(0)
                .andPublishStatusEqualTo(1);
        return goodsProductFeign.listByExample(example);
    }

    @Override
    public List<GoodsProductCategory> getProductCateList(Long parentId) {
        GoodsProductCategoryExample example = new GoodsProductCategoryExample();
        example.createCriteria()
                .andShowStatusEqualTo(1)
                .andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        return goodsProductCategoryFeign.listByExample(example);
    }

    @Override
    public List<ContextSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ContextSubjectExample example = new ContextSubjectExample();
        ContextSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        if(cateId!=null){
            criteria.andCategoryIdEqualTo(cateId);
        }
        return contextSubjectFeign.listByExample(example);
    }

    @Override
    public List<GoodsProduct> hotProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return goodsBrandFeign.getHotProductList(offset, pageSize);
    }

    @Override
    public List<GoodsProduct> newProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return goodsBrandFeign.getNewProductList(offset, pageSize);
    }

    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        AdFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            AdFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                AdFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = goodsBrandFeign.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    //获取下一个场次信息
    private AdFlashPromotionSession getNextFlashPromotionSession(Date date) {
        AdFlashPromotionSessionExample sessionExample = new AdFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(date);
        sessionExample.setOrderByClause("start_time asc");
        List<AdFlashPromotionSession> promotionSessionList = adFlashPromotionSessionFeign.listByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    private List<AdHomeAdvertise> getHomeAdvertiseList() {
        AdHomeAdvertiseExample example = new AdHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return adHomeAdvertiseFeign.selectByExample(example);
    }

    //根据时间获取秒杀活动
    private AdFlashPromotion getFlashPromotion(Date date) {
        Date currDate = DateUtil.getDate(date);
        AdFlashPromotionExample example = new AdFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currDate)
                .andEndDateGreaterThanOrEqualTo(currDate);
        List<AdFlashPromotion> flashPromotionList = adFlashPromotionFeign.listByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }

    //根据时间获取秒杀场次
    private AdFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        AdFlashPromotionSessionExample sessionExample = new AdFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<AdFlashPromotionSession> promotionSessionList = adFlashPromotionSessionFeign.listByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }
}
