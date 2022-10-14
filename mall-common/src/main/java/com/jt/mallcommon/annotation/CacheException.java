package com.jt.mallcommon.annotation;

import java.lang.annotation.*;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:49
 * 自定义注解，有该注解的缓存方法会抛出异常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
