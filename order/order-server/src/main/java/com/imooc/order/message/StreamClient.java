package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:42 PM 8/20/2018
 */
public interface StreamClient {

    String INPUT = "myMessage";
    String INPUT2 = "myMessage2";

    @Input(StreamClient.INPUT + "Input")
    SubscribableChannel input();

    @Output(StreamClient.INPUT + "Output")
    MessageChannel output();

    @Input(StreamClient.INPUT2 + "Input")
    SubscribableChannel input2();

    @Output(StreamClient.INPUT2 + "Output")
    MessageChannel output2();
}
