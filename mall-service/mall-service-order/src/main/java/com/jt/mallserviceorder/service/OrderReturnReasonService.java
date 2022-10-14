package com.jt.mallserviceorder.service;


import com.jt.model.OrderReturnReason;

import java.util.List;

/**
 * 订单原因管理Service
 */
public interface OrderReturnReasonService {
    /**
     * 添加订单原因
     */
    int create(OrderReturnReason returnReason);

    /**
     * 修改退货原因
     */
    int update(Long id, OrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     */
    List<OrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * 批量修改退货原因状态
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * 获取单个退货原因详情信息
     */
    OrderReturnReason getItem(Long id);
}
