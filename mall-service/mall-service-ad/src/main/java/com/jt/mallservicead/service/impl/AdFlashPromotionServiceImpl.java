package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdFlashPromotionMapper;
import com.jt.mallservicead.service.AdFlashPromotionService;
import com.jt.model.AdFlashPromotion;
import com.jt.model.AdFlashPromotionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 限时购活动管理Service实现类
 */
@Service
public class AdFlashPromotionServiceImpl implements AdFlashPromotionService {
    @Autowired
    private AdFlashPromotionMapper flashPromotionMapper;

    @Override
    public int create(AdFlashPromotion flashPromotion) {
        flashPromotion.setCreateTime(new Date());
        return flashPromotionMapper.insert(flashPromotion);
    }

    @Override
    public int update(Long id, AdFlashPromotion flashPromotion) {
        flashPromotion.setId(id);
        return flashPromotionMapper.updateByPrimaryKey(flashPromotion);
    }

    @Override
    public int delete(Long id) {
        return flashPromotionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        AdFlashPromotion flashPromotion = new AdFlashPromotion();
        flashPromotion.setId(id);
        flashPromotion.setStatus(status);
        return flashPromotionMapper.updateByPrimaryKeySelective(flashPromotion);
    }

    @Override
    public AdFlashPromotion getItem(Long id) {
        return flashPromotionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AdFlashPromotionExample example = new AdFlashPromotionExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andTitleLike("%" + keyword + "%");
        }
        return flashPromotionMapper.selectByExample(example);
    }

    @Override
    public List<AdFlashPromotion> listByExample(AdFlashPromotionExample adFlashPromotionExample){
        return flashPromotionMapper.selectByExample(adFlashPromotionExample);
    }
}
