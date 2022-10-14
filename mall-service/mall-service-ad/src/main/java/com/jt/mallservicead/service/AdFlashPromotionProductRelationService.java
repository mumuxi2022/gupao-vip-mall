package com.jt.mallservicead.service;

import com.jt.dto.AdFlashPromotionProduct;
import com.jt.model.AdFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 限时购商品关联管理Service
 */
public interface AdFlashPromotionProductRelationService {
    /**
     * 批量添加关联
     */
    @Transactional
    int create(List<AdFlashPromotionProductRelation> relationList);

    /**
     * 修改关联相关信息
     */
    int update(Long id, AdFlashPromotionProductRelation relation);

    /**
     * 删除关联
     */
    int delete(Long id);

    /**
     * 获取关联详情
     */
    AdFlashPromotionProductRelation getItem(Long id);

    /**
     * 分页查询相关商品及促销信息
     *
     * @param flashPromotionId        限时购id
     * @param flashPromotionSessionId 限时购场次id
     */
    List<AdFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * 根据活动和场次id获取商品关系数量
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);

    List<AdFlashPromotionProductRelation> listBySomeId(Long flashPromotionId,Long sessionId);
}
