package com.yi.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Feign消费服务并实现负载均衡
 * GitHub中的配置更新之后只需要手动通过post请求执行
 * http://localhost:8888/bus/refresh
 * 这个总的配置服务就会全部刷新
 * 如果配置webhooks可实现自动更新，可惜我是内网GitHub访问不进来o(╥﹏╥)o
 * @author YI
 * @date 2018-4-18 18:17:09
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
