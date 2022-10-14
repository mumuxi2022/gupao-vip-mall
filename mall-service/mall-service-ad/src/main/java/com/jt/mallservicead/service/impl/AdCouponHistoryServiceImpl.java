package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.domain.AdCouponHistoryDetail;
import com.jt.mallservicead.mapper.AdCouponHistoryMapper;
import com.jt.mallservicead.service.AdCouponHistoryService;
import com.jt.model.AdCoupon;
import com.jt.model.AdCouponHistory;
import com.jt.model.AdCouponHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 优惠券领取记录管理Service实现类
 */
@Service
public class AdCouponHistoryServiceImpl implements AdCouponHistoryService {
    @Autowired
    private AdCouponHistoryMapper historyMapper;
    @Override
    public List<AdCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AdCouponHistoryExample example = new AdCouponHistoryExample();
        AdCouponHistoryExample.Criteria criteria = example.createCriteria();
        if(couponId!=null){
            criteria.andCouponIdEqualTo(couponId);
        }
        if(useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        if(!StringUtils.isEmpty(orderSn)){
            criteria.andOrderSnEqualTo(orderSn);
        }
        return historyMapper.selectByExample(example);
    }

    @Override
    public long countByExample(AdCouponHistoryExample example) {
        return historyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdCouponHistoryExample example) {
        return historyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdCouponHistory record) {
        return historyMapper.insert(record);
    }

    @Override
    public int insertSelective(AdCouponHistory record) {
        return historyMapper.insertSelective(record);
    }

    @Override
    public List<AdCouponHistory> selectByExample(AdCouponHistoryExample example) {
        return historyMapper.selectByExample(example);
    }

    @Override
    public AdCouponHistory selectByPrimaryKey(Long id) {
        return historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdCouponHistory record, AdCouponHistoryExample example) {
        return historyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AdCouponHistory record, AdCouponHistoryExample example) {
        return historyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdCouponHistory record) {
        return historyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdCouponHistory record) {
        return historyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AdCouponHistoryDetail> getDetailList(Long memberId){
        return historyMapper.getDetailList(memberId);
    }

    @Override
    public List<AdCoupon> getCouponList(Long memberId, Integer useStatus){
        return historyMapper.getCouponList(memberId,useStatus);
    }
}
