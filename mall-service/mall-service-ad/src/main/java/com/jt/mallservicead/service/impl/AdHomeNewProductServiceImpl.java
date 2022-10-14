package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdHomeNewProductMapper;
import com.jt.mallservicead.service.AdHomeNewProductService;
import com.jt.model.AdHomeNewProduct;
import com.jt.model.AdHomeNewProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页新品推荐管理Service实现类
 */
@Service
public class AdHomeNewProductServiceImpl implements AdHomeNewProductService {
    @Autowired
    private AdHomeNewProductMapper homeNewProductMapper;
    @Override
    public int create(List<AdHomeNewProduct> homeNewProductList) {
        for (AdHomeNewProduct AdHomeNewProduct : homeNewProductList) {
            AdHomeNewProduct.setRecommendStatus(1);
            AdHomeNewProduct.setSort(0);
            homeNewProductMapper.insert(AdHomeNewProduct);
        }
        return homeNewProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        AdHomeNewProduct homeNewProduct = new AdHomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return homeNewProductMapper.updateByPrimaryKeySelective(homeNewProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        AdHomeNewProductExample example = new AdHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        return homeNewProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        AdHomeNewProductExample example = new AdHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        AdHomeNewProduct record = new AdHomeNewProduct();
        record.setRecommendStatus(recommendStatus);
        return homeNewProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<AdHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AdHomeNewProductExample example = new AdHomeNewProductExample();
        AdHomeNewProductExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%"+productName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeNewProductMapper.selectByExample(example);
    }

    @Override
    public List<Long> listAllProductId(){
        return homeNewProductMapper.listAllProductId();
    }
}
