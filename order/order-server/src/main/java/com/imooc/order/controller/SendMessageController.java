package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:46 PM 8/20/2018
 */
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

   /* @GetMapping("/sendMessage")
    public  void process(){
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }*/

    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO ();
        orderDTO.setOrderId ("123456");
        streamClient.output ().send (MessageBuilder.withPayload (orderDTO).build ());
    }

}
