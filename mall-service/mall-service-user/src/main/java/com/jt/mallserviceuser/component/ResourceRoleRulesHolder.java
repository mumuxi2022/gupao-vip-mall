package com.jt.mallserviceuser.component;

import com.jt.mallserviceuser.service.UserResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 帅气的景天老师
 * @create 2022/9/14 18:37
 * 资源与角色访问对应关系操作组件
 */
@Component
public class ResourceRoleRulesHolder {

    @Autowired
    private UserResourceService resourceService;

    @PostConstruct
    public void initResourceRolesMap(){
        resourceService.initResourceRolesMap();
    }
}
