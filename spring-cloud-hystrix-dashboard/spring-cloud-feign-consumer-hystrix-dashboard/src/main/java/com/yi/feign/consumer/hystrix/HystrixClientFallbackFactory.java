package com.yi.feign.consumer.hystrix;

import com.yi.feign.consumer.feignclient.HomeClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * HomeClient类熔断器回调方法
 * @author YI
 * @date 2018-4-17 16:46:43
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HomeClient> {

    @Override
    public HomeClient create(Throwable throwable) {
        return () -> "feign + hystrix ,提供者服务挂了";
    }
}
