package com.jt.mallserviceauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.jt")
@EnableFeignClients(basePackages = "com.jt")
public class MallServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceAuthApplication.class, args);
    }

}
