package com.yi.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 使用Filter进行安全拦截过滤
 * @EnableZuulProxy 开启 Zuul 服务网关
 * http://127.0.0.1:9000/api-a?token=token-uuid&username=美女&password=123456
 * http://127.0.0.1:9000/api-b?token=token-uuid&username=美女&password=123456
 * @author YI
 * @date 2018-4-17 18:44:06
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterApplication.class, args);
    }
}
