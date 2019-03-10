package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MicroserviceHystrixTurbineExtendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHystrixTurbineExtendsApplication.class, args);
    }

}

