package com.jt.mallserviceorder.service.impl;

import com.jt.mallserviceorder.mapper.OrderCompanyAddressMapper;
import com.jt.mallserviceorder.service.OrderCompanyAddressService;
import com.jt.model.OrderCompanyAddress;
import com.jt.model.OrderCompanyAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OrderCompanyAddressServiceImpl implements OrderCompanyAddressService {
    @Autowired
    private OrderCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OrderCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OrderCompanyAddressExample());
    }
}
