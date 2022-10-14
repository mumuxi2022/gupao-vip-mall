package com.jt.mallservicead.service;

import com.jt.model.AdHomeRecommendProduct;
import com.jt.model.AdHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页人气推荐管理Service
 */
public interface AdHomeRecommendProductService {
    /**
     * 添加首页推荐
     */
    @Transactional
    int create(List<AdHomeRecommendProduct> homeRecommendProductList);

    /**
     * 修改推荐排序
     */
    int updateSort(Long id, Integer sort);

    /**
     * 批量删除推荐
     */
    int delete(List<Long> ids);

    /**
     * 更新推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询推荐
     */
    List<AdHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);

    List<Long> listAllProductId();
}
