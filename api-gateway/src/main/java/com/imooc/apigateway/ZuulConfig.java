package com.imooc.apigateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:32 AM 8/22/2018
 */

@Component
public class ZuulConfig {

    @ConfigurationProperties("Zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return  new ZuulProperties ();
    }
}
