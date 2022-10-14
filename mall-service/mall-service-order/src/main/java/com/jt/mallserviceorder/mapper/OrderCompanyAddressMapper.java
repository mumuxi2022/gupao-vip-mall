package com.jt.mallserviceorder.mapper;

import com.jt.model.OrderCompanyAddress;
import com.jt.model.OrderCompanyAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCompanyAddressMapper {
    long countByExample(OrderCompanyAddressExample example);

    int deleteByExample(OrderCompanyAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCompanyAddress record);

    int insertSelective(OrderCompanyAddress record);

    List<OrderCompanyAddress> selectByExample(OrderCompanyAddressExample example);

    OrderCompanyAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCompanyAddress record, @Param("example") OrderCompanyAddressExample example);

    int updateByExample(@Param("record") OrderCompanyAddress record, @Param("example") OrderCompanyAddressExample example);

    int updateByPrimaryKeySelective(OrderCompanyAddress record);

    int updateByPrimaryKey(OrderCompanyAddress record);
}