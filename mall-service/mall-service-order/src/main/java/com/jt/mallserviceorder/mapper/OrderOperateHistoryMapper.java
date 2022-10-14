package com.jt.mallserviceorder.mapper;

import com.jt.model.OrderOperateHistory;
import com.jt.model.OrderOperateHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOperateHistoryMapper {
    long countByExample(OrderOperateHistoryExample example);

    int deleteByExample(OrderOperateHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderOperateHistory record);

    int insertSelective(OrderOperateHistory record);

    List<OrderOperateHistory> selectByExample(OrderOperateHistoryExample example);

    OrderOperateHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderOperateHistory record, @Param("example") OrderOperateHistoryExample example);

    int updateByExample(@Param("record") OrderOperateHistory record, @Param("example") OrderOperateHistoryExample example);

    int updateByPrimaryKeySelective(OrderOperateHistory record);

    int updateByPrimaryKey(OrderOperateHistory record);

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<OrderOperateHistory> orderOperateHistoryList);
}