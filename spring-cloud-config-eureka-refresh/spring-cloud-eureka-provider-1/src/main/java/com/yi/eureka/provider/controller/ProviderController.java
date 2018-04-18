package com.yi.eureka.provider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取配置文件数据
 * 注解@RefreshScope要加在声明@Controller声明的类上，否则refresh之后Conroller拿不到最新的值，会默认调用缓存
 * @author YI
 * @date 2018-4-18 16:06:41
 */
@RefreshScope
@RestController
public class ProviderController {
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
}
