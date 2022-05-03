package com.icypt.learn;

import com.icypt.myrule.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "microservice-provider-register-multiple", configuration = RibbonRuleConfig.class)
public class MicroserviceConsumerRegisterMultiple {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerRegisterMultiple.class, args);
    }
}
