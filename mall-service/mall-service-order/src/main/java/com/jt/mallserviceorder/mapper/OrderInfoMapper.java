package com.jt.mallserviceorder.mapper;

import com.jt.dto.OrderDeliveryParam;
import com.jt.dto.OrderDetail;
import com.jt.dto.OrderInfoQueryParam;
import com.jt.model.OrderInfo;
import com.jt.model.OrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    /**
     * 条件查询订单
     */
    List<OrderInfo> getList(@Param("queryParam") OrderInfoQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OrderDetail getDetail(@Param("id") Long id);
}