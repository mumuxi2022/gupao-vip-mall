package com.jt.mallserviceorder.service;


import com.jt.model.OrderCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 */
public interface OrderCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OrderCompanyAddress> list();
}
