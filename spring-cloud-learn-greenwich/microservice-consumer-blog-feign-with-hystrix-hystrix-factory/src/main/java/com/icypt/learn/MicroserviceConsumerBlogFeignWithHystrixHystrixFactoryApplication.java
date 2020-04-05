package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceConsumerBlogFeignWithHystrixHystrixFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerBlogFeignWithHystrixHystrixFactoryApplication.class, args);
	}

}
