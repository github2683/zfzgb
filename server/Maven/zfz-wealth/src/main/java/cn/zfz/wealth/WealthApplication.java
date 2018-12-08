package cn.zfz.wealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //注册为服务调用方式（消费方），通过服务中心去调用已经注册到服务中心的服务
@SpringBootApplication
public class WealthApplication {

    @Bean
    @LoadBalanced  //客户端 负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(WealthApplication.class, args);
    }
}
