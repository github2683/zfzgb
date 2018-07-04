package com.zhc.springcloud.feignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignserviceApplication.class, args);
    }
}
