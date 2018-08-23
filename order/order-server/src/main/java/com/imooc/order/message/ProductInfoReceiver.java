package com.imooc.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.imooc.order.utils.JsonUtil;
import com.imooc.product.common.ProductInfoOutput;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:58 AM 8/21/2018
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    public static final String PRODUC_STOCK_TEMPLATE = "product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        //message-》ProductInfoOutput
        List <ProductInfoOutput> productInfoOutputList = (List <ProductInfoOutput>) JsonUtil.fromJson (message,new TypeReference <List <ProductInfoOutput>> () {
        });
        log.info ("从队列{} 接收到消息：{}","productInfo",productInfoOutputList);

        //存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {

            stringRedisTemplate.opsForValue ().set (String.format (PRODUC_STOCK_TEMPLATE,productInfoOutput.getProductId ()),
                    String.valueOf (productInfoOutput.getProductStock ()));
        }


    }
}
