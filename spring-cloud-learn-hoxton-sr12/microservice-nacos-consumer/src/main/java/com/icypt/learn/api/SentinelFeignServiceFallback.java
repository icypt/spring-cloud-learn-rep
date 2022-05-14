package com.icypt.learn.api;

import org.springframework.stereotype.Component;

@Component
public class SentinelFeignServiceFallback implements SentinelFeignService {
    @Override
    public String testException(String id) {
        return "降级处理";
    }
}
