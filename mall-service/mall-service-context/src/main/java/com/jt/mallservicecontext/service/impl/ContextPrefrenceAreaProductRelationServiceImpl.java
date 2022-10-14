package com.jt.mallservicecontext.service.impl;

import com.jt.mallservicecontext.mapper.ContextPrefrenceAreaProductRelationMapper;
import com.jt.mallservicecontext.service.ContextPrefrenceAreaProductRelationService;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;
import com.jt.model.ContextSubjectProductRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优选专区和产品关系Service实现类
 */
@Service
public class ContextPrefrenceAreaProductRelationServiceImpl implements ContextPrefrenceAreaProductRelationService {
    @Autowired
    private ContextPrefrenceAreaProductRelationMapper contextPrefrenceAreaProductRelationMapper;

    @Override
    public int insertList(List<ContextPrefrenceAreaProductRelation> prefrenceAreaProductRelationList){
        return contextPrefrenceAreaProductRelationMapper.insertList(prefrenceAreaProductRelationList);
    }

    @Override
    public int deleteByExample(ContextPrefrenceAreaProductRelationExample subjectProductRelationExample){
        return contextPrefrenceAreaProductRelationMapper.deleteByExample(subjectProductRelationExample);
    }

    @Override
    public List<ContextPrefrenceAreaProductRelation> getListByProductId(Long productId){
        return contextPrefrenceAreaProductRelationMapper.getListByProductId(productId);
    }
}
