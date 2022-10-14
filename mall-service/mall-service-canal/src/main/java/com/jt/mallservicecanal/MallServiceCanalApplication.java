package com.jt.mallservicecanal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.jt")
@SpringBootApplication
public class MallServiceCanalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceCanalApplication.class, args);
    }

}
