package com.liqihua.demo.consumer.controller;

import com.liqihua.demo.dto.OrderDTO;
import com.liqihua.demo.service.OrderFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liqihua
 * @since 2019/3/7
 */
@RestController
@RequestMapping("/testController")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderFeignApi orderFeignApi;

    @RequestMapping("/listOrder")
    public String listOrder(String aa){
        return restTemplate.getForObject("http://order-provider/myOrder/orderController/list?aa="+aa,String.class);
    }


    @RequestMapping("/listOrderFeign")
    public String listOrderFeign(String aa){
        return orderFeignApi.list(aa);
    }

    @RequestMapping("/getOrder")
    public OrderDTO getOrder(Integer id){
        return orderFeignApi.getOrder(id);
    }


}
