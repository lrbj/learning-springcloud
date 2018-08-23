package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Kayla,Ye
 * @Description: 接收mq消息
 * @Date:Created in 2:32 PM 8/20/2018
 */
@Slf4j
@Component
public class MqReceiver {
    // 1、@RabbitListener(queues = "myQueue")
    // 2、自动创建
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3、 自动创建 exchange 和queue 绑定
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
    public void process(String message) {
        log.info ("MqReceiver:{}",message);
    }

    /**
     * 数码供应商
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange("myOrder"), key = "computer", value = @Queue("computerOrder")))
    public void processComputer(String message) {
        log.info ("computer  MqReceiver:{}",message);
    }


    /**
     * 水果供应商
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange("myOrder"), key = "fruit", value = @Queue("fruitOrder")))
    public void processFruit(String message) {
        log.info ("fruit  MqReceiver:{}",message);
    }
}
