package com.jt.mallserviceorder.mapper;

import com.jt.model.OrderReturnReason;
import com.jt.model.OrderReturnReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReturnReasonMapper {
    long countByExample(OrderReturnReasonExample example);

    int deleteByExample(OrderReturnReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnReason record);

    int insertSelective(OrderReturnReason record);

    List<OrderReturnReason> selectByExample(OrderReturnReasonExample example);

    OrderReturnReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderReturnReason record, @Param("example") OrderReturnReasonExample example);

    int updateByExample(@Param("record") OrderReturnReason record, @Param("example") OrderReturnReasonExample example);

    int updateByPrimaryKeySelective(OrderReturnReason record);

    int updateByPrimaryKey(OrderReturnReason record);
}