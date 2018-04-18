package com.yi.eureka.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务提供方 将自身服务注册到 Eureka 注册中心，从而使服务消费方能够找到Provider-2
 * @author YI
 * @date 2018-4-17 09:34:28
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {

    @Value("${server.port}")
    String port;
    @Value("${content}")
    String content;
    @Value("${file}")
    String file;
    @Value("${say}")
    String say;

    @RequestMapping("/")
    @ResponseBody
    public Map home() {
        Map<String, Object> map = new HashMap<>();
        map.put("port:", port);
        map.put("content:", content);
        map.put("file:", file);
        map.put("say:", say);

        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
}