package com.jt.mallservicead.service;


import com.jt.dto.AdFlashPromotionSessionDetail;
import com.jt.model.AdFlashPromotionSession;
import com.jt.model.AdFlashPromotionSessionExample;

import java.util.List;

/**
 * 限时购场次管理Service
 */
public interface AdFlashPromotionSessionService {
    /**
     * 添加场次
     */
    int create(AdFlashPromotionSession promotionSession);

    /**
     * 修改场次
     */
    int update(Long id, AdFlashPromotionSession promotionSession);

    /**
     * 修改场次启用状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 删除场次
     */
    int delete(Long id);

    /**
     * 获取详情
     */
    AdFlashPromotionSession getItem(Long id);

    /**
     * 根据启用状态获取场次列表
     */
    List<AdFlashPromotionSession> list();

    /**
     * 获取全部可选场次及其数量
     */
    List<AdFlashPromotionSessionDetail> selectList(Long flashPromotionId);

    List<AdFlashPromotionSession> listByExample(AdFlashPromotionSessionExample adFlashPromotionExample);
}
