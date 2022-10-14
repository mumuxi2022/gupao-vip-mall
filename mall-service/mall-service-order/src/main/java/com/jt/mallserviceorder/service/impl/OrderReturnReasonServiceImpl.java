package com.jt.mallserviceorder.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallserviceorder.mapper.OrderReturnReasonMapper;
import com.jt.mallserviceorder.service.OrderReturnReasonService;
import com.jt.model.OrderReturnReason;
import com.jt.model.OrderReturnReasonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单原因管理Service实现类
 */
@Service
public class OrderReturnReasonServiceImpl implements OrderReturnReasonService {
    @Autowired
    private OrderReturnReasonMapper returnReasonMapper;
    @Override
    public int create(OrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return returnReasonMapper.insert(returnReason);
    }

    @Override
    public int update(Long id, OrderReturnReason returnReason) {
        returnReason.setId(id);
        return returnReasonMapper.updateByPrimaryKey(returnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        OrderReturnReasonExample example = new OrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return returnReasonMapper.deleteByExample(example);
    }

    @Override
    public List<OrderReturnReason> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        OrderReturnReasonExample example = new OrderReturnReasonExample();
        example.setOrderByClause("sort desc");
        return returnReasonMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        if(!status.equals(0)&&!status.equals(1)){
            return 0;
        }
        OrderReturnReason record = new OrderReturnReason();
        record.setStatus(status);
        OrderReturnReasonExample example = new OrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return returnReasonMapper.updateByExampleSelective(record,example);
    }

    @Override
    public OrderReturnReason getItem(Long id) {
        return returnReasonMapper.selectByPrimaryKey(id);
    }
}
