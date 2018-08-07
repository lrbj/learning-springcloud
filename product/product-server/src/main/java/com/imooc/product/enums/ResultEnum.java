package com.imooc.product.enums;

import lombok.Getter;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 2:53 PM 8/2/2018
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST ( 1,"商品不存在" ),
    PRODUCT_STOCK_ERROR ( 2,"库存不足" ),;
    private Integer code;
    private String message;


    ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
