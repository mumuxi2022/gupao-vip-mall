package com.jt.mallservicegoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jt")
@SpringBootApplication
public class MallServiceGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceGoodsApplication.class, args);
    }

}
