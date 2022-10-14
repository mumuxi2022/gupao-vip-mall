package com.jt.mallserviceportal.config;

import com.jt.mallcommon.config.BaseSwaggerConfig;
import com.jt.mallcommon.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.jt.mallserviceportal.controller")
                .title("mall前台系统")
                .description("mall前台相关接口文档")
                .contactName("jt")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
