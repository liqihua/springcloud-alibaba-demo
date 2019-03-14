package com.liqihua.demo.service.fallback;

import com.liqihua.demo.dto.OrderDTO;
import com.liqihua.demo.service.OrderFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liqihua
 * @since 2019/3/14
 * OrderFeignApi 远程调用失败时的降级执行类
 * 需要用@Bean注册到spring容器中，否则无法生效，consumer启动失败
 */
public class OrderFeignFallback implements OrderFeignApi {
    public static final Logger LOG = LoggerFactory.getLogger(OrderFeignFallback.class);

    @Override
    public String list(String aa) {
        LOG.info("OrderFeignApi -> list() aa:{} 调用失败，执行降级代码 ...",aa);
        return "OrderFeignApi -> list() 调用失败";
    }

    @Override
    public OrderDTO getOrder(Integer id) {
        LOG.info("OrderFeignApi -> getOrder() id:{}  调用失败，执行降级代码 ...",id);
        OrderDTO dto = new OrderDTO();
        dto.setTitle("调用失败");
        dto.setCode("ERROR");
        dto.setId(40000);
        return dto;
    }
}
