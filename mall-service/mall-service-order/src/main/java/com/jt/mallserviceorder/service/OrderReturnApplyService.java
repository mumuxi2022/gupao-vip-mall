package com.jt.mallserviceorder.service;


import com.jt.dto.OrderReturnApplyQueryParam;
import com.jt.dto.OrderReturnApplyResult;
import com.jt.dto.OrderUpdateStatusParam;
import com.jt.model.OrderReturnApply;
import com.jt.model.OrderReturnApply;
import com.jt.model.OrderReturnApplyExample;

import java.util.List;

/**
 * 退货申请管理Service
 */
public interface OrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OrderReturnApply> list(OrderReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OrderUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OrderReturnApplyResult getItem(Long id);

    long countByExample(OrderReturnApplyExample example);

    int deleteByExample(OrderReturnApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnApply record);

    int insertSelective(OrderReturnApply record);

    List<OrderReturnApply> selectByExample(OrderReturnApplyExample example);

    OrderReturnApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(OrderReturnApply record, OrderReturnApplyExample example);

    int updateByExample(OrderReturnApply record,OrderReturnApplyExample example);

    int updateByPrimaryKeySelective(OrderReturnApply record);

    int updateByPrimaryKey(OrderReturnApply record);
}
