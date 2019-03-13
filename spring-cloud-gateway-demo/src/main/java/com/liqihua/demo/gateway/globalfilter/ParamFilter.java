package com.liqihua.demo.gateway.globalfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author liqihua
 * @since 2019/3/12
 * 全局过滤器类->参数打印类
 */
public class ParamFilter implements GlobalFilter, Ordered {
    public static final Logger LOG = LoggerFactory.getLogger(ParamFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOG.info("ParamFilter -> filter()");
        MultiValueMap<String, String> paramMap = exchange.getRequest().getQueryParams();
        if(paramMap != null){
            for(Map.Entry entry : paramMap.entrySet()){
                LOG.info("paramName:{},paramValue:{}",entry.getKey(),entry.getValue());
            }
        }
        return chain.filter(exchange);
    }


    /**
     * 优先级，值越小优先级越大
     * @return
     */
    @Override
    public int getOrder() {
        return 5;
    }
}
