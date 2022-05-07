package com.icypt.learn.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // 路由构造器
        RouteLocatorBuilder.Builder routes = builder.routes();
        // 设置路径
        routes.route("rout1", r -> {
            return r.path("/ent").uri("http://news.baidu.com/ent");
        });
        return routes.build();
    }
}
