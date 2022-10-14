package com.jt.feign;

import com.jt.model.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-order")
public interface PortalOrderItemFeign {

    @PostMapping(value = "/orderItem/insertList")
    int insertList(@RequestBody List<OrderItem> list);

}
