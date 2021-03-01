package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
@EnableDiscoveryClient
public class MicroserviceCloudGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCloudGateWayApplication.class, args);
	}

}

