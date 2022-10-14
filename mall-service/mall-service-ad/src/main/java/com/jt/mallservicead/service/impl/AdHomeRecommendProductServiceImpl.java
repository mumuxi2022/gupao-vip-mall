package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdHomeRecommendProductMapper;
import com.jt.mallservicead.service.AdHomeRecommendProductService;
import com.jt.model.AdHomeRecommendProduct;
import com.jt.model.AdHomeRecommendProductExample;
import com.jt.model.AdHomeRecommendSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页人气推荐管理Service实现类
 */
@Service
public class AdHomeRecommendProductServiceImpl implements AdHomeRecommendProductService {
    @Autowired
    private AdHomeRecommendProductMapper recommendProductMapper;
    @Override
    public int create(List<AdHomeRecommendProduct> homeRecommendProductList) {
        for (AdHomeRecommendProduct recommendProduct : homeRecommendProductList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            recommendProductMapper.insert(recommendProduct);
        }
        return homeRecommendProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        AdHomeRecommendProduct recommendProduct = new AdHomeRecommendProduct();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        AdHomeRecommendProductExample example = new AdHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        AdHomeRecommendProductExample example = new AdHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        AdHomeRecommendProduct record = new AdHomeRecommendProduct();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<AdHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AdHomeRecommendProductExample example = new AdHomeRecommendProductExample();
        AdHomeRecommendProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }

    @Override
    public List<Long> listAllProductId() {
        return recommendProductMapper.listAllProductId();
    }
}
