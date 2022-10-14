package com.jt.mallservicecontext.service;


import com.jt.model.ContextPrefrenceArea;
import com.jt.model.ContextPrefrenceAreaProductRelation;
import com.jt.model.ContextSubjectProductRelation;
import com.jt.model.ContextSubjectProductRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 专题商品关系Service
 */
public interface ContextSubjectProductRelationService {
    /**
     * 批量创建
     */
    int insertList(List<ContextSubjectProductRelation> subjectProductRelationList);

    int deleteByExample(ContextSubjectProductRelationExample subjectProductRelationExample);

    List<ContextSubjectProductRelation> getListByProductId(Long productId);
}
