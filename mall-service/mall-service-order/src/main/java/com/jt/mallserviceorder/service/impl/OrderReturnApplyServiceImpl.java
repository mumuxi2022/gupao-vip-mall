package com.jt.mallserviceorder.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.OrderReturnApplyQueryParam;
import com.jt.dto.OrderReturnApplyResult;
import com.jt.dto.OrderUpdateStatusParam;
import com.jt.mallserviceorder.mapper.OrderReturnApplyMapper;
import com.jt.mallserviceorder.service.OrderReturnApplyService;
import com.jt.model.OrderReturnApply;
import com.jt.model.OrderReturnApplyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单退货管理Service
 */
@Service
public class OrderReturnApplyServiceImpl implements OrderReturnApplyService {
    @Autowired
    private OrderReturnApplyMapper returnApplyMapper;
    @Override
    public List<OrderReturnApply> list(OrderReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return returnApplyMapper.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        OrderReturnApplyExample example = new OrderReturnApplyExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, OrderUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OrderReturnApply returnApply = new OrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }

    @Override
    public OrderReturnApplyResult getItem(Long id) {
        return returnApplyMapper.getDetail(id);
    }

    @Override
    public long countByExample(OrderReturnApplyExample example) {
        return returnApplyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderReturnApplyExample example) {
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return returnApplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderReturnApply record) {
        return returnApplyMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderReturnApply record) {
        return returnApplyMapper.insertSelective(record);
    }

    @Override
    public List<OrderReturnApply> selectByExample(OrderReturnApplyExample example) {
        return returnApplyMapper.selectByExample(example);
    }

    @Override
    public OrderReturnApply selectByPrimaryKey(Long id) {
        return returnApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderReturnApply record, OrderReturnApplyExample example) {
        return returnApplyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderReturnApply record, OrderReturnApplyExample example) {
        return returnApplyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderReturnApply record) {
        return returnApplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderReturnApply record) {
        return returnApplyMapper.updateByPrimaryKey(record);
    }
}
