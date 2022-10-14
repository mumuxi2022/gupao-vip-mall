package com.jt.mallserviceorder.mapper;

import com.jt.model.OrderCartItem;
import com.jt.model.OrderCartItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCartItemMapper {
    long countByExample(OrderCartItemExample example);

    int deleteByExample(OrderCartItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCartItem record);

    int insertSelective(OrderCartItem record);

    List<OrderCartItem> selectByExample(OrderCartItemExample example);

    OrderCartItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCartItem record, @Param("example") OrderCartItemExample example);

    int updateByExample(@Param("record") OrderCartItem record, @Param("example") OrderCartItemExample example);

    int updateByPrimaryKeySelective(OrderCartItem record);

    int updateByPrimaryKey(OrderCartItem record);
}