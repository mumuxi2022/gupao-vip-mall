package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdHomeRecommendSubjectMapper;
import com.jt.mallservicead.service.AdHomeRecommendSubjectService;
import com.jt.model.AdHomeRecommendSubject;
import com.jt.model.AdHomeRecommendSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 首页专题推荐管理Service实现类
 */
@Service
public class AdHomeRecommendSubjectServiceImpl implements AdHomeRecommendSubjectService {
    @Autowired
    private AdHomeRecommendSubjectMapper recommendProductMapper;
    @Override
    public int create(List<AdHomeRecommendSubject> recommendSubjectList) {
        for (AdHomeRecommendSubject recommendProduct : recommendSubjectList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            recommendProductMapper.insert(recommendProduct);
        }
        return recommendSubjectList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        AdHomeRecommendSubject recommendProduct = new AdHomeRecommendSubject();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        AdHomeRecommendSubjectExample example = new AdHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        AdHomeRecommendSubjectExample example = new AdHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        AdHomeRecommendSubject record = new AdHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return recommendProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<AdHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AdHomeRecommendSubjectExample example = new AdHomeRecommendSubjectExample();
        AdHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(subjectName)){
            criteria.andSubjectNameLike("%"+subjectName+"%");
        }
        if(recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }

    @Override
    public List<Long> listAllSubjectId() {
        return recommendProductMapper.listAllSubjectId();
    }
}
