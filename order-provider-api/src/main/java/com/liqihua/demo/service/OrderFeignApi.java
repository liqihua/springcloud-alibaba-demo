package com.liqihua.demo.service;

import com.liqihua.demo.config.FeignConfiguration;
import com.liqihua.demo.dto.OrderDTO;
import com.liqihua.demo.service.fallback.OrderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liqihua
 * @since 2019/3/7
 * FeignClien调用接口
 */
@FeignClient(name = "order-provider",fallback = OrderFeignFallback.class,configuration = FeignConfiguration.class)
public interface OrderFeignApi {

    @RequestMapping("/myOrder/orderController/list")
    String list(@RequestParam("aa") String aa);

    @RequestMapping("/myOrder/orderController/getOrder")
    OrderDTO getOrder(@RequestParam("id") Integer id);
}
