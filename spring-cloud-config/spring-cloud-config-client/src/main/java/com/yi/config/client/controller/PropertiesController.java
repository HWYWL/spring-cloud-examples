package com.yi.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取GitHub中的文件配置
 * @author YI
 * @date 2018-4-18 10:59:18
 */
@RestController
public class PropertiesController {
    @Value("${content}")
    String content;
    @Value("${file}")
    String file;
    @Value("${say}")
    String say;

    @RequestMapping("/")
    public String home() {
        String str = new StringBuffer().append("content:" + content).append(" file:" + file).append(" say:" + say).toString();

        return str;
    }
}
