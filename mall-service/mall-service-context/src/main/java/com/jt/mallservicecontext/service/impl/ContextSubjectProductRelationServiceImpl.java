package com.jt.mallservicecontext.service.impl;

import com.jt.mallservicecontext.mapper.ContextPrefrenceAreaProductRelationMapper;
import com.jt.mallservicecontext.mapper.ContextSubjectProductRelationMapper;
import com.jt.mallservicecontext.service.ContextSubjectProductRelationService;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;
import com.jt.model.ContextSubjectProductRelation;
import com.jt.model.ContextSubjectProductRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品和专题关系关系Service实现类
 */
@Service
public class ContextSubjectProductRelationServiceImpl implements ContextSubjectProductRelationService {
    @Autowired
    private ContextSubjectProductRelationMapper contextSubjectProductRelationMapper;

    @Override
    public int insertList(List<ContextSubjectProductRelation> subjectProductRelationList) {
        return contextSubjectProductRelationMapper.insertList(subjectProductRelationList);
    }

    @Override
    public int deleteByExample(ContextSubjectProductRelationExample subjectProductRelationExample){
        return contextSubjectProductRelationMapper.deleteByExample(subjectProductRelationExample);
    }

    @Override
    public List<ContextSubjectProductRelation> getListByProductId(Long productId){
        return contextSubjectProductRelationMapper.getListByProductId(productId);
    }
}
