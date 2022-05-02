package com.icypt.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProviderPayment {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderPayment.class,args);
    }
}
