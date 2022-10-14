package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdHomeBrandMapper;
import com.jt.mallservicead.service.AdHomeBrandService;
import com.jt.model.AdHomeBrand;
import com.jt.model.AdHomeBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页品牌管理Service实现类
 */
@Service
public class AdHomeBrandServiceImpl implements AdHomeBrandService {
    @Autowired
    private AdHomeBrandMapper homeBrandMapper;
    @Override
    public int create(List<AdHomeBrand> homeBrandList) {
        for (AdHomeBrand AdHomeBrand : homeBrandList) {
            AdHomeBrand.setRecommendStatus(1);
            AdHomeBrand.setSort(0);
            homeBrandMapper.insert(AdHomeBrand);
        }
        return homeBrandList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        AdHomeBrand homeBrand = new AdHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return homeBrandMapper.updateByPrimaryKeySelective(homeBrand);
    }

    @Override
    public int delete(List<Long> ids) {
        AdHomeBrandExample example = new AdHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        return homeBrandMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        AdHomeBrandExample example = new AdHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        AdHomeBrand record = new AdHomeBrand();
        record.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<AdHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AdHomeBrandExample example = new AdHomeBrandExample();
        AdHomeBrandExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(brandName)){
            criteria.andBrandNameLike("%"+brandName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeBrandMapper.selectByExample(example);
    }

    @Override
    public List<AdHomeBrand> listAll(){
        return homeBrandMapper.selectAll();
    }
}
