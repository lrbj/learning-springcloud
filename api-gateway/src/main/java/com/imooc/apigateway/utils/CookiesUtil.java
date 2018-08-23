package com.imooc.apigateway.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:56 PM 8/22/2018
 */
public class CookiesUtil {

    /**
     * 设置cookie
     * @param response
     * @param name
     * @param value
     * @param Maxage
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int Maxage){
        Cookie cookie = new Cookie (name, value);
        cookie.setPath ("/");
        cookie.setMaxAge (Maxage);
        response.addCookie (cookie);

    }

    public static Cookie get(HttpServletRequest request,String name) {
        Cookie[] cookies = request.getCookies ();
        if(cookies != null){
            for (Cookie cookie: cookies){
                if(name.equals (cookie.getName ())){
                    return  cookie;
                }
            }
        }
        return  null;
    }
}
