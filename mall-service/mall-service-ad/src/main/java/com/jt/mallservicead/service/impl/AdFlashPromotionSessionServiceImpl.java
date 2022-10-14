package com.jt.mallservicead.service.impl;

import com.jt.dto.AdFlashPromotionSessionDetail;
import com.jt.mallservicead.mapper.AdFlashPromotionSessionMapper;
import com.jt.mallservicead.service.AdFlashPromotionProductRelationService;
import com.jt.mallservicead.service.AdFlashPromotionSessionService;
import com.jt.model.AdFlashPromotionSession;
import com.jt.model.AdFlashPromotionSessionExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 限时购场次管理Service实现类
 */
@Service
public class AdFlashPromotionSessionServiceImpl implements AdFlashPromotionSessionService {
    @Autowired
    private AdFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private AdFlashPromotionProductRelationService relationService;

    @Override
    public int create(AdFlashPromotionSession promotionSession) {
        promotionSession.setCreateTime(new Date());
        return promotionSessionMapper.insert(promotionSession);
    }

    @Override
    public int update(Long id, AdFlashPromotionSession promotionSession) {
        promotionSession.setId(id);
        return promotionSessionMapper.updateByPrimaryKey(promotionSession);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        AdFlashPromotionSession promotionSession = new AdFlashPromotionSession();
        promotionSession.setId(id);
        promotionSession.setStatus(status);
        return promotionSessionMapper.updateByPrimaryKeySelective(promotionSession);
    }

    @Override
    public int delete(Long id) {
        return promotionSessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public AdFlashPromotionSession getItem(Long id) {
        return promotionSessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdFlashPromotionSession> list() {
        AdFlashPromotionSessionExample example = new AdFlashPromotionSessionExample();
        return promotionSessionMapper.selectByExample(example);
    }

    @Override
    public List<AdFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<AdFlashPromotionSessionDetail> result = new ArrayList<>();
        AdFlashPromotionSessionExample example = new AdFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<AdFlashPromotionSession> list = promotionSessionMapper.selectByExample(example);
        for (AdFlashPromotionSession promotionSession : list) {
            AdFlashPromotionSessionDetail detail = new AdFlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            long count = relationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return result;
    }

    @Override
    public List<AdFlashPromotionSession> listByExample(AdFlashPromotionSessionExample adFlashPromotionExample){
        return promotionSessionMapper.selectByExample(adFlashPromotionExample);
    }
}
