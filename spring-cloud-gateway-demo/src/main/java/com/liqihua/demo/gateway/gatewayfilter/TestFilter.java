package com.liqihua.demo.gateway.gatewayfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author liqihua
 * @since 2019/3/12
 * 局部过滤器类
 */
public class TestFilter implements GatewayFilter, Ordered {
    public static final Logger LOG = LoggerFactory.getLogger(TestFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOG.info("TestFilter -> filter()");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
