package com.jt.mallserviceorder.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.*;
import com.jt.mallserviceorder.mapper.OrderInfoMapper;
import com.jt.mallserviceorder.mapper.OrderOperateHistoryMapper;
import com.jt.mallserviceorder.service.OrderInfoService;
import com.jt.model.OrderInfo;
import com.jt.model.OrderInfoExample;
import com.jt.model.OrderOperateHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderMapper;
    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;

    @Override
    public List<OrderInfo> list(OrderInfoQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.getList(queryParam);
    }

    @Override
    public int delivery(List<OrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = orderMapper.delivery(deliveryParamList);
        //添加操作记录
        List<OrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(orderDeliveryParam -> {
                    OrderOperateHistory history = new OrderOperateHistory();
                    history.setOrderId(orderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryMapper.insertList(operateHistoryList);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        OrderInfo record = new OrderInfo();
        record.setStatus(4);
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = orderMapper.updateByExampleSelective(record, example);
        List<OrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OrderOperateHistory history = new OrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());
        orderOperateHistoryMapper.insertList(historyList);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        OrderInfo record = new OrderInfo();
        record.setDeleteStatus(1);
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public OrderDetail detail(Long id) {
        return orderMapper.getDetail(id);
    }

    @Override
    public int updateReceiverInfo(OrderReceiverInfoParam receiverInfoParam) {
        OrderInfo order = new OrderInfo();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateMoneyInfo(OrderMoneyInfoParam moneyInfoParam) {
        OrderInfo order = new OrderInfo();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //插入操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OrderInfo order = new OrderInfo();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public long countByExample(OrderInfoExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderInfoExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public List<OrderInfo> selectByExample(OrderInfoExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public OrderInfo selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderInfo record, OrderInfoExample example) {
        return orderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderInfo record, OrderInfoExample example) {
        return orderMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderMapper.updateByPrimaryKey(record);
    }
}
