package com.liqihua.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author liqihua
 * @since 2019/3/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.liqihua.*")
public class RunOrderConsumer {

    public static void main(String[] args) {
        SpringApplication.run(RunOrderConsumer.class, args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
