package com.imooc.user.utils;

import java.util.Random;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:27 AM 7/19/2018
 */
public class KeyUtil {


    /**
     * 生成唯一的主键
     * 格式： 时间+随机数
     * @return
     */
    public   static synchronized  String  genUniqueKey(){

        Random random = new Random (  );
        Integer  number = random.nextInt ( 900000) + 100000;
        return System.currentTimeMillis () +String.valueOf (number);
    }
}
