package com.imooc.product.VO;

import lombok.Data;


/**
 * @Author: Kayla,Ye
 * @Description: http返回的最外层对象
 * @Date:Created in 10:41 AM 7/16/2018
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

}
