package com.jt.mallservicead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.jt")
@SpringBootApplication
public class MallServiceAdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceAdApplication.class, args);
    }

}
