package com.yi.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Feign消费服务并实现负载均衡
 * GitHub中的配置更新之后需要手动通过post请求执行
 * http://localhost:8081/refresh
 * http://localhost:8082/refresh
 * http://localhost:8083/refresh
 * 才能刷新配置
 * @author YI
 * @date 2018-4-17 14:37:35
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
