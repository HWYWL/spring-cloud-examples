package com.yi.zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化拦截器
 * @author YI
 * @date 2018-4-17 18:57:49
 */
@Configuration
public class FilterInit {
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public PasswordFilter PasswordFilter() {
        return new PasswordFilter();
    }
}
