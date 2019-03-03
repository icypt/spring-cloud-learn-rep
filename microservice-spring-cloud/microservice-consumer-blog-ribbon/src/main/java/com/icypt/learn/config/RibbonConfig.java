package com.icypt.learn.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/3 21:50
 * version：1.0
 * description：
 */
@Configuration
@ExcludeFromComponentScan
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        RandomRule randomRule = new RandomRule();
        return randomRule;
    }
}
