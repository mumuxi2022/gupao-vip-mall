package com.jt.dto;

import com.jt.model.UserMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:05
 */
@Getter
@Setter
public class UserMenuNode extends UserMenu{

    @ApiModelProperty(value = "子级菜单")
    private List<UserMenuNode> children;
}
