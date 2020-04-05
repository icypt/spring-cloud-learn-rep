package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class MicroserviceConsumerBlogFeignWithHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerBlogFeignWithHystrixApplication.class, args);
	}

}
