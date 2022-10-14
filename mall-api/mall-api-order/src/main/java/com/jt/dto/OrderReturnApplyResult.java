package com.jt.dto;

import com.jt.model.OrderCompanyAddress;
import com.jt.model.OrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 */
public class OrderReturnApplyResult extends OrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OrderCompanyAddress companyAddress;
}
