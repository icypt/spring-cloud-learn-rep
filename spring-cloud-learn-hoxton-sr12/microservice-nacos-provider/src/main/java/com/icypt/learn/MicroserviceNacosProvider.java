package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceNacosProvider {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceNacosProvider.class, args);
    }
}
