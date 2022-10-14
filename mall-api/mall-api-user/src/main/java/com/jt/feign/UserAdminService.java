package com.jt.feign;

import com.jt.mallcommon.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 帅气的景天老师
 * @create 2022/9/13 16:09
 */
@FeignClient("mall-service-user")
public interface UserAdminService {
    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam("username") String username);
}
