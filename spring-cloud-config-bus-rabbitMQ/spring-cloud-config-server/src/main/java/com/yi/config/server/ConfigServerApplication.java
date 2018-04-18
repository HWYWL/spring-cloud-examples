package com.yi.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Config Server服务端
 * http://localhost:8888/springCloudConfig/pre
 * http://localhost:8888/springCloudConfig/dev
 * http://localhost:8888/springCloudConfig/test
 * @author YI
 * @date 2018-4-18 09:31:21
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
