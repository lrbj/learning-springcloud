package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:28 AM 8/1/2018
 */
@RestController
public class ServerController {
    @GetMapping("/msg")
    public  String  msg(){
        return  "this is product 'msg'2";
    }
}
