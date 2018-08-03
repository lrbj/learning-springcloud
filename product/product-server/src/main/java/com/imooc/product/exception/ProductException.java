package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 2:51 PM 8/2/2018
 */
public class ProductException extends  RuntimeException {
    private  Integer code;
    public ProductException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
    public  ProductException(ResultEnum  resultEnum){
        super(resultEnum.getMessage ());
        this.code  =resultEnum.getCode ();
    }
}
