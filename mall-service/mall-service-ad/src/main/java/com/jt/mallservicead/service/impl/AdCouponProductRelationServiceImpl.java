package com.jt.mallservicead.service.impl;

import com.jt.mallservicead.mapper.AdCouponProductRelationMapper;
import com.jt.mallservicead.service.AdCouponProductRelationService;
import com.jt.model.AdCouponProductRelation;
import com.jt.model.AdCouponProductRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券商品关联管理Service实现类
 */
@Service
public class AdCouponProductRelationServiceImpl implements AdCouponProductRelationService {
    @Autowired
    private AdCouponProductRelationMapper historyMapper;

    @Override
    public long countByExample(AdCouponProductRelationExample example) {
        return historyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdCouponProductRelationExample example) {
        return historyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdCouponProductRelation record) {
        return historyMapper.insert(record);
    }

    @Override
    public int insertSelective(AdCouponProductRelation record) {
        return historyMapper.insertSelective(record);
    }

    @Override
    public List<AdCouponProductRelation> selectByExample(AdCouponProductRelationExample example) {
        return historyMapper.selectByExample(example);
    }

    @Override
    public AdCouponProductRelation selectByPrimaryKey(Long id) {
        return historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdCouponProductRelation record, AdCouponProductRelationExample example) {
        return historyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AdCouponProductRelation record, AdCouponProductRelationExample example) {
        return historyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdCouponProductRelation record) {
        return historyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdCouponProductRelation record) {
        return historyMapper.updateByPrimaryKey(record);
    }


}
