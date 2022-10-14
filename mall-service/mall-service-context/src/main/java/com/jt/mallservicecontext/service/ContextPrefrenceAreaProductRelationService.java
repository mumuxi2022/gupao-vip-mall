package com.jt.mallservicecontext.service;


import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextPrefrenceAreaProductRelationExample;

import java.util.List;

/**
 * 优选专区和产品关系Service
 */
public interface ContextPrefrenceAreaProductRelationService {
    /**
     * 批量创建
     */
    int insertList(List<ContextPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);

    int deleteByExample(ContextPrefrenceAreaProductRelationExample subjectProductRelationExample);

    List<ContextPrefrenceAreaProductRelation> getListByProductId(Long productId);
}
