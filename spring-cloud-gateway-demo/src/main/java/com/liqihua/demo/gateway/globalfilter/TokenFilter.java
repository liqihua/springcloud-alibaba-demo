package com.liqihua.demo.gateway.globalfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author liqihua
 * @since 2019/3/12
 * 全局过滤器类->token校验类
 */
public class TokenFilter implements GlobalFilter, Ordered {
    public static final Logger LOG = LoggerFactory.getLogger(TokenFilter.class);


    /**
     * 1.判断请求参数中是否包含参数token
     * 2.判断token的值是否等于 yy
     * 3.是就允许通过，否就返回401未授权
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOG.info("TokenFilter -> filter()");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null || !"yy".equals(token)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }


    /**
     * 优先级，值越小优先级越大
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
