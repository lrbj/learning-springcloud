package com.imooc.product.enums;

import lombok.Getter;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:21 AM 7/16/2018
 */
@Getter
public enum ProductStatusEnum {

    UP( 0, "在架"),
    DOWN(1, "下架"),
    ;

    private  Integer code;
    private  String  message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
