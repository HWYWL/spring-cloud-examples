package com.yi.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供方 将自身服务注册到 Eureka 注册中心，从而使服务消费方能够找到
 * @author YI
 * @date 2018-4-17 09:34:28
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {
    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
}
