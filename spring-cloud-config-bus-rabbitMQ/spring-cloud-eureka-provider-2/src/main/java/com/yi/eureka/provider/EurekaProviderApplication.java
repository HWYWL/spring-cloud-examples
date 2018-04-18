package com.yi.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 服务提供方 将自身服务注册到 Eureka 注册中心，从而使服务消费方能够找到Provider-2
 * @author YI
 * @date 2018-4-17 09:34:28
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
}