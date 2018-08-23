package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 1:52 PM 8/23/2018
 */
@RestController
@DefaultProperties(defaultFallback = "defaulFallback")
public class HystrixController {
    //@HystrixCommand(commandProperties = {@HystrixProperty (name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")}) //超时时间设置


//    @HystrixCommand(commandProperties = {
//            @HystrixProperty (name = "circuitBreaker.enabled", value = "true"), //服务熔断
//            @HystrixProperty (name="circuitBreaker.requestVolumeThreshold", value ="10" ),
//            @HystrixProperty (name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
//            @HystrixProperty (name="circuitBreaker.errorThresholdPercentage", value = "60")})
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if(0 == number%2){
            return  "success";
        }

        RestTemplate restTemplate = new RestTemplate ();
        return restTemplate.postForObject ("http://127.0.0.1:8001/product/listForOrder",
                Arrays.asList ("157875196366160022"),
                String.class);
        //throw  new RuntimeException ("发生异常了");
    }


    private String fallback() {
        return "太拥挤了，请稍候再试～～";
    }

    private String defaulFallback() {
        return "默认提示：太拥挤了，请稍候再试～～";
    }
}
