package com.imooc.order.enums;

import lombok.Getter;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:30 PM 7/16/2018
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private  Integer code;
    private  String  message;

    PayStatusEnum(Integer code, String  message){
        this.code = code;
        this.message = message;
    }
}
