package com.jt.mallserviceorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jt")
@SpringBootApplication
public class MallServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceOrderApplication.class, args);
    }

}
