package com.jt.mallserviceportal.service;


import com.jt.domain.OrderReturnApplyParam;

/**
 * 订单退货管理Service
 */
public interface OrderInfoPortalReturnApplyService {
    /**
     * 提交申请
     */
    int create(OrderReturnApplyParam returnApply);
}
