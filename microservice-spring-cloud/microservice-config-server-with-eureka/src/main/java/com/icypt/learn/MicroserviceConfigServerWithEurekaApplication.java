package com.icypt.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigServerWithEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServerWithEurekaApplication.class, args);
	}

}
