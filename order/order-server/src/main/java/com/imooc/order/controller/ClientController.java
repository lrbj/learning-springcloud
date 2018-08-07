package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:33 AM 8/1/2018
 */
@RestController
@Slf4j
public class ClientController {


   @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public  String getProductMsg(){

        String response = productClient.productMsg ();
        //String response = "test";
        log.info("response = {}", response);
        return  response;
    }

    @GetMapping("/getProductList")
    public  String getProductList(){
       List<ProductInfo> productInfoList =  productClient.listForOrder ( Arrays.asList ("164103465734242707"));
       log.info(" response = {}", productInfoList);
       return  "OK";
    }

    @GetMapping("/decreaseStock")
    public  String productDecreaseStock( ){

        productClient.decreaseStock ( Arrays.asList ( new CartDTO (  "157875196366160022", 3) ) );
        return "OK";

    }

}
