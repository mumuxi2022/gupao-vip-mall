package com.jt.mallservicead.service.impl;

import com.jt.mallservicead.mapper.AdCouponProductCategoryRelationMapper;
import com.jt.mallservicead.service.AdCouponProductCategoryRelationService;
import com.jt.model.AdCouponProductCategoryRelation;
import com.jt.model.AdCouponProductCategoryRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券领取记录管理Service实现类
 */
@Service
public class AdCouponProductCategoryRelationServiceImpl implements AdCouponProductCategoryRelationService {
    @Autowired
    private AdCouponProductCategoryRelationMapper historyMapper;

    @Override
    public long countByExample(AdCouponProductCategoryRelationExample example) {
        return historyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdCouponProductCategoryRelationExample example) {
        return historyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdCouponProductCategoryRelation record) {
        return historyMapper.insert(record);
    }

    @Override
    public int insertSelective(AdCouponProductCategoryRelation record) {
        return historyMapper.insertSelective(record);
    }

    @Override
    public List<AdCouponProductCategoryRelation> selectByExample(AdCouponProductCategoryRelationExample example) {
        return historyMapper.selectByExample(example);
    }

    @Override
    public AdCouponProductCategoryRelation selectByPrimaryKey(Long id) {
        return historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdCouponProductCategoryRelation record, AdCouponProductCategoryRelationExample example) {
        return historyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AdCouponProductCategoryRelation record, AdCouponProductCategoryRelationExample example) {
        return historyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdCouponProductCategoryRelation record) {
        return historyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdCouponProductCategoryRelation record) {
        return historyMapper.updateByPrimaryKey(record);
    }

}
