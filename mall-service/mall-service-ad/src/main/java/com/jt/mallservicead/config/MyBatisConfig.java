package com.jt.mallservicead.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 13:46
 * MyBatis相关配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.jt.mallservicead.mapper"})
public class MyBatisConfig {
}