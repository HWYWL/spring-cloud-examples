package com.yi.feign.consumer.feignclient;

import com.yi.feign.consumer.hystrix.HystrixClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过@FeignClient（"服务名"），来指定调用哪个服务，添加熔断器回调
 * @author YI
 * @date 2018-4-17 14:41:02
 */
@FeignClient(value ="eureka-provider",fallbackFactory = HystrixClientFallbackFactory.class)
public interface HomeClient {

    /**
     * 调用eureka-provider服务的 / 方法
     * @return
     */
    @GetMapping("/")
    String consumer();
}
