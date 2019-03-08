package com.liqihua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liqihua
 * @since 2019/3/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RunOrderProvider {

    public static void main(String[] args) {
        SpringApplication.run(RunOrderProvider.class, args);
    }

}
