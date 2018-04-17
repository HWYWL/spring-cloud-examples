package com.yi.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 使用Feign消费服务并实现负载均衡,使用feign内置熔断器,使用图形化界面面
 * 监控地址：http://127.0.0.1:9000/hystrix
 * @author YI
 * @date 2018-4-17 17:10:23
 */
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignHystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixConsumerApplication.class, args);
    }
}
