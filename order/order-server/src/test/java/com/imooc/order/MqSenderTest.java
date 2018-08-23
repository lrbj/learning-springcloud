package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送mq消息测试
 * Created by 廖师兄
 * 2018-02-04 22:06
 */
@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend ("myQueue","now " + new Date ());
    }

    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend ("myOrder","computer","now " + new Date ());
    }
}
