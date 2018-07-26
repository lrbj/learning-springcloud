package com.imooc.order.enums;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 11:01 AM 7/19/2018
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(1,"参数错误"),
    ;
    private  Integer code;

    private  String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
