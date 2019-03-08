package com.liqihua.demo.provider;

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

}
