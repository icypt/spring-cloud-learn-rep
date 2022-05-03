package com.icypt.learn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }

}
