package com.jt.mallserviceuser.service.impl;

import com.jt.mallcommon.service.RedisService;
import com.jt.mallserviceuser.service.UserAdminCacheService;
import com.jt.mallserviceuser.service.UserAdminService;
import com.jt.model.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * UserAdminCacheService实现类
 */
@Service
public class UserAdminCacheServiceImpl implements UserAdminCacheService {
    @Autowired
    private UserAdminService adminService;
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Override
    public void delAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public UserAdmin getAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        return (UserAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UserAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getId();
        redisService.set(key, admin, REDIS_EXPIRE);
    }
}
