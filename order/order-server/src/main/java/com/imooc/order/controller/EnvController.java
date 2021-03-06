package com.imooc.order.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 1:26 PM 8/9/2018
 */
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env; // ???????

    @GetMapping("/print")
    public String print() {
        return env;
    }
}