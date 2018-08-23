package com.imooc.order.controller;

import com.imooc.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 1:32 PM 8/20/2018
 */
@RestController
public class GirlController {
    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return "name:" + girlConfig.getName () + "age:" + girlConfig.getAge ();
    }
}
