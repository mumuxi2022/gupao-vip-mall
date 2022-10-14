package com.jt.mallserviceauth.config;

import com.jt.mallcommon.config.BaseSwaggerConfig;
import com.jt.mallcommon.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 帅气的景天老师
 * @create 2022/9/13 16:04
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.jt.mallserviceauth.controller")
                .title("mall认证中心")
                .description("mall认证中心相关接口文档")
                .contactName("jt")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
