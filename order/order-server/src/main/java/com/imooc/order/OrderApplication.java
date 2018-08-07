package com.imooc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@EnableFeignClients(basePackages = "com.imooc.product.client")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringCloudApplication
@ComponentScan(basePackages = "com.imooc.order")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run ( OrderApplication.class,args );
    }
}
