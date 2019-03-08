package com.liqihua.demo.provider;

import com.liqihua.demo.dto.OrderDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqihua
 * @since 2019/3/7
 */
@RestController
@RequestMapping("/orderController")
public class OrderController {


    @RequestMapping("/list")
    public String list(String aa){
        return "order list " + aa;
    }


    @RequestMapping("/getOrder")
    public OrderDTO getOrder(Integer id){
        OrderDTO dto = new OrderDTO();
        dto.setId(88);
        dto.setCode("123456");
        dto.setTitle("taobao");
        return dto;
    }

}
