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
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

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
     * 路由配置，可以移动到application.yml中，除了局部过滤器GatewayFilter
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("aabbcc",r -> r.path("/testController/**").uri("http://localhost:9100").filters(new TestFilter())) // 添加局部过滤器TestFilter
                .build();

    }


    /**
     * 注册全局过滤器-TokenFilter
     * @return
     */
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    /**
     * 注册全局过滤器-ParamFilter
     * @return
     */
    @Bean
    public ParamFilter paramFilter() {
        return new ParamFilter();
    }

    /**
     * 根据URI限流
     * @return
     */
    @Bean
    KeyResolver uriKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }

}
