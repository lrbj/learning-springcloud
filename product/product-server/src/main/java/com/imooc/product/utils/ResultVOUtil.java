package com.imooc.product.utils;

import com.imooc.product.VO.ResultVO;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:10 PM 7/16/2018
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO ();
        resultVO.setData ( object );
        resultVO.setCode ( 0 );
        resultVO.setMsg ( "成功" );
        return resultVO;

    }

    public static ResultVO fail(Object object) {
        ResultVO resultVO = new ResultVO ();
        resultVO.setCode ( -1 );
        resultVO.setMsg ( "失败" );
        resultVO.setData ( object );

        return resultVO;
    }
}
