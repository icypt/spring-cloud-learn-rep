package com.icypt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启动注册中心
public class SCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudEurekaServerApplication.class, args);
    }

}
