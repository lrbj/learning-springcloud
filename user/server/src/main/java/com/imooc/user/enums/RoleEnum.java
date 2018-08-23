package com.imooc.user.enums;

import lombok.Getter;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:52 PM 8/22/2018
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2,"卖家"),
    ;

    private  Integer code;

    private  String message;

    RoleEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
