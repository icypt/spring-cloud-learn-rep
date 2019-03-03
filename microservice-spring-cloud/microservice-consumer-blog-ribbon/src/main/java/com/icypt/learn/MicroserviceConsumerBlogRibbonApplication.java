package com.icypt.learn;

import com.icypt.learn.config.ExcludeFromComponentScan;
import com.icypt.learn.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfig.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
public class MicroserviceConsumerBlogRibbonApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerBlogRibbonApplication.class, args);
	}

}
