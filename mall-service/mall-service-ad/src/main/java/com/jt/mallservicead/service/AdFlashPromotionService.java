package com.jt.mallservicead.service;


import com.jt.model.AdFlashPromotion;
import com.jt.model.AdFlashPromotionExample;

import java.util.List;

/**
 * 限时购活动管理Service
 */
public interface AdFlashPromotionService {
    /**
     * 添加活动
     */
    int create(AdFlashPromotion flashPromotion);

    /**
     * 修改指定活动
     */
    int update(Long id, AdFlashPromotion flashPromotion);

    /**
     * 删除单个活动
     */
    int delete(Long id);

    /**
     * 修改上下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取详细信息
     */
    AdFlashPromotion getItem(Long id);

    /**
     * 分页查询活动
     */
    List<AdFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);

    List<AdFlashPromotion> listByExample(AdFlashPromotionExample adFlashPromotionExample);
}
