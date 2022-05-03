package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConsumerOrder {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerOrder.class, args);
    }
}
