package com.imooc.order.VO;

import lombok.Data;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:34 PM 7/31/2018
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
