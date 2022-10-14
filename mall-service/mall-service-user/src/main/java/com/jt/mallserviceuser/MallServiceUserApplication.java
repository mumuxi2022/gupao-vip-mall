package com.jt.mallserviceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jt")
@SpringBootApplication
public class MallServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceUserApplication.class, args);
    }

}
