package com.imooc.apigateway.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 1:28 PM 8/23/2018
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ();
        final CorsConfiguration config = new CorsConfiguration ();
        config.setAllowCredentials (true); //支持cookie 跨域
        config.setAllowedOrigins (Arrays.asList ("*"));
        config.setAllowedHeaders (Arrays.asList ("*"));
        config.setAllowedMethods (Arrays.asList ("*"));
        config.setMaxAge (300l);//设置时间有效

        source.registerCorsConfiguration ("/**",config);
        return  new CorsFilter (source);
    }
}
