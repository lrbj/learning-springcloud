package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author: Kayla,Ye
 * @Description: 接收端
 * @Date:Created in 3:44 PM 8/20/2018
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /**
     * 接收消息
     *
     * @param message
     */
    @StreamListener(StreamClient.INPUT + "Output")
    @SendTo(StreamClient.INPUT2 + "Output")
    public String process(OrderDTO message) {
        log.info ("StreamReceiver: {}",message);
        return "received.";
    }

    @StreamListener(value = StreamClient.INPUT2 + "Output")
    public void process2(String message) {
        log.info ("StreamReceiver2: {}",message);
    }

}
