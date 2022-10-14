package com.jt.mallservicecontext.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicecontext.mapper.ContextSubjectMapper;
import com.jt.mallservicecontext.service.ContextSubjectService;
import com.jt.model.ContextSubject;
import com.jt.model.ContextSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品专题Service实现类
 */
@Service
public class ContextSubjectServiceImpl implements ContextSubjectService {
    @Autowired
    private ContextSubjectMapper subjectMapper;

    @Autowired
//    private AdHomeRecommendSubjectFeign adHomeRecommendSubjectFeign;

    @Override
    public List<ContextSubject> listAll() {
        return subjectMapper.selectByExample(new ContextSubjectExample());
    }

    @Override
    public List<ContextSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ContextSubjectExample example = new ContextSubjectExample();
        ContextSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }

//    @Override
//    public List<ContextSubject> getRecommendSubjectList(Integer offset, Integer limit){
//        List<Long> ids = adHomeRecommendSubjectFeign.listAllSubjectId();
//        return subjectMapper.getRecommendSubjectList(ids,offset,limit);
//    }
//
    @Override
    public List<ContextSubject> listByExample(ContextSubjectExample contextSubjectExample){
        return subjectMapper.selectByExample(contextSubjectExample);
    }
}
