package com.zhc.springcloud.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //提供restful访问服务
@EnableEurekaClient //服务提供者
@SpringBootApplication
public class EurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }


    //读配置属性参数
    @Value("${server.port}")
    String port;

    //提供一个接口服务
    @RequestMapping(value = "/testService",method = RequestMethod.GET)
    public String home(@RequestParam String name) {
        return "service "+name+",i am from port:" +port;
    }


}
