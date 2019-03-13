package com.liqihua.demo.gateway;

import com.liqihua.demo.gateway.gatewayfilter.TestFilter;
import com.liqihua.demo.gateway.globalfilter.ParamFilter;
import com.liqihua.demo.gateway.globalfilter.TokenFilter;
import com.liqihua.demo.service.OrderFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author liqihua
 * @since 2019/3/12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.liqihua.*")
public class RunGateway {
    public static final Logger LOG = LoggerFactory.getLogger(RunGateway.class);

    @Autowired
    private OrderFeignApi orderFeignApi;

    public static void main(String[] args) {
        SpringApplication.run(RunGateway.class, args);
    }


    /**
     * 这部分已移动到配置文件application.yml中
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                //.route("test1",r -> r.path("/testController/**").uri("http://localhost:9100")) // http://网关地址:网关端口/testController/aa/bb -> http://localhost:9100/testController/aa/bb
                .route("test2",r -> r.path("/myOrder/**").uri("lb://order-provider")) // http://网关地址:网关端口/myOrder/aa/bb/cc -> http://order-provider/myOrder/aa/bb/cc
                .route("aabbcc",r -> r.path("/testController/**").uri("http://localhost:9100").filters(new TestFilter()))
                .build();

    }



    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public ParamFilter paramFilter() {
        return new ParamFilter();
    }



}
