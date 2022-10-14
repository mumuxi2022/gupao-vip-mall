package com.jt.mallserviceportal.service.impl;

import com.jt.domain.OrderReturnApplyParam;
import com.jt.feign.OrderReturnApplyFeign;
import com.jt.mallserviceportal.service.OrderInfoPortalReturnApplyService;
import com.jt.model.OrderReturnApply;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 订单退货管理Service实现类
 */
@Service
public class OrderInfoPortalReturnApplyServiceImpl implements OrderInfoPortalReturnApplyService {
    @Autowired
    private OrderReturnApplyFeign returnApplyMapper;
    @Override
    public int create(OrderReturnApplyParam returnApply) {
        OrderReturnApply realApply = new OrderReturnApply();
        BeanUtils.copyProperties(returnApply,realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);
        return returnApplyMapper.insert(realApply);
    }
}
