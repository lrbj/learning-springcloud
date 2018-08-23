package com.imooc.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 2:34 PM 8/6/2018
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper ();

    /**
     * 转换为json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString (object);
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        }
        return null;
    }

    public static Object fromJson(String message,TypeReference typeReference) {
        try {
            return objectMapper.readValue (message,typeReference);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return null;
    }
}
