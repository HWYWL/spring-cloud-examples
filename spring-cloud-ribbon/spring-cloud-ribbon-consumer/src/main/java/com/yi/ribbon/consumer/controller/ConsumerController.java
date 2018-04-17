package com.yi.ribbon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡调用
 * @author YI
 * @date 2018-4-17 11:51:17
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 负载均衡会轮询返回服务器的端口
     * @return
     */
    @GetMapping(value = "/hello")
    public String hello() {
        //用过服务提供方的名字调用，例如http://eureka-provider/aaa?name=张三&age=18
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }
}