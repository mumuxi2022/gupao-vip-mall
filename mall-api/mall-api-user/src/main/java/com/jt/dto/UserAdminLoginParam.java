package com.jt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:04
 * 用户登录参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAdminLoginParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
