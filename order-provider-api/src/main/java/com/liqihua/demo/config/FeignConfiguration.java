package com.liqihua.demo.config;

import com.liqihua.demo.service.fallback.OrderFeignFallback;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqihua
 * @since 2019/3/13
 * Feign配置类
 */
@Configuration
public class FeignConfiguration {


    /**
     * 注册 OrderFeignApi 的服务降级类，OrderFeignApi 调用失败会执行该类相应的代码
     * @return
     */
    @Bean
    public OrderFeignFallback orderFeignFallback(){
        return new OrderFeignFallback();
    }



    /**
     * 日志输出配置：
     * 记录所有级别，具体想输出什么级别，可以在调用端的application.yml配置
     * 如在consumer端写：
     *
     * logging:
     *   level:
     *     com.liqihua.demo.service.OrderFeignApi: debug
     *
     * 那么 OrderFeignApi 就是输出 debug 级别的日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        //这里，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }



}
