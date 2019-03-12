package com.liqihua.demo.service;

import com.liqihua.demo.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liqihua
 * @since 2019/3/7
 */
@FeignClient(name = "order-provider")
public interface OrderFeignApi {

    @RequestMapping("/myOrder/orderController/list")
    String list(@RequestParam("aa") String aa);

    @RequestMapping("/myOrder/orderController/getOrder")
    OrderDTO getOrder(@RequestParam("id") Integer id);
}
