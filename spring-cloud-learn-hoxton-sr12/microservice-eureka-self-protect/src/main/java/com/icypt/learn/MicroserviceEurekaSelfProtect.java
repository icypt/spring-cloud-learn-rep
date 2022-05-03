package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaSelfProtect {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaSelfProtect.class,args);
    }
}
