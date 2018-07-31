package com.imooc.order.utils;

import com.imooc.order.VO.ResultVO;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:37 PM 7/31/2018
 */
public class ResultVOUtil {

    public  static  ResultVO  success(Object object){
        ResultVO resultVO = new ResultVO ();
        resultVO.setCode(0);
        resultVO.setMsg ("成功" );
        resultVO.setData ( object );
        return  resultVO;
    }
}
