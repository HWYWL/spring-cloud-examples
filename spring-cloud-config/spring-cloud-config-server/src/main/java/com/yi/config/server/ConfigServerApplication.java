package com.yi.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config Server服务端
 * http://localhost:8888/springCloudConfig/pre
 * http://localhost:8888/springCloudConfig/dev
 * http://localhost:8888/springCloudConfig/test
 * @author YI
 * @date 2018-4-18 09:31:21
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
