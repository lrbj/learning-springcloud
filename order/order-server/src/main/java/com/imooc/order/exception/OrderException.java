package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:59 AM 7/19/2018
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message) {
        super (message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super (resultEnum.getMessage ());
        this.code = resultEnum.getCode ();
    }
}
