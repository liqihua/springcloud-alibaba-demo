package com.liqihua.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author liqihua
 * @since 2019/3/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RunGateway {

    public static void main(String[] args) {
        SpringApplication.run(RunGateway.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("test1",r -> r.path("/testController/**").uri("http://localhost:9100")) // http://网关地址:网关端口/testController/aa/bb -> http://localhost:9100/testController/aa/bb
                .route("test2",r -> r.path("/myOrder/**").uri("lb://order-provider")) // http://网关地址:网关端口/myOrder/aa/bb/cc -> http://order-provider/myOrder/aa/bb/cc
                .build();

    }

}
