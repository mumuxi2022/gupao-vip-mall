package com.jt.mallservicecontext.service;


import com.jt.model.ContextSubject;
import com.jt.model.ContextSubjectExample;

import java.util.List;

/**
 * 商品专题Service
 */
public interface ContextSubjectService {
    /**
     * 查询所有专题
     */
    List<ContextSubject> listAll();

    /**
     * 分页查询专题
     */
    List<ContextSubject> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取推荐专题
     */
//    List<ContextSubject> getRecommendSubjectList(Integer offset, Integer limit);
//
    List<ContextSubject> listByExample(ContextSubjectExample contextSubjectExample);
}
