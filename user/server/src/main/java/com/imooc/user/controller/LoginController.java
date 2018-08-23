package com.imooc.user.controller;

import org.springframework.util.StringUtils;
import com.imooc.user.VO.ResultVO;
import com.imooc.user.constant.CookieConstant;
import com.imooc.user.constant.RedisConstant;
import com.imooc.user.dataobject.UserInfo;
import com.imooc.user.enums.ResultEnum;
import com.imooc.user.enums.RoleEnum;
import com.imooc.user.service.UserService;
import com.imooc.user.utils.CookiesUtil;
import com.imooc.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:13 PM 8/22/2018
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private  UserService userService;
    @Autowired
    private StringRedisTemplate  stringRedisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,HttpServletResponse response){
        //1、openid 和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid (openid);
        if(  null == userInfo ){
            return ResultVOUtil.error (ResultEnum.LOGIN_FAIL);
        }

        //2、判断角色
        if(RoleEnum.BUYER.getCode () != userInfo.getRole ()){
            return  ResultVOUtil.error (ResultEnum.ROLE_ERROR);
        }

        //3、cookie 里设置opeid =abc
        CookiesUtil.set (response,CookieConstant.OPENID, openid, CookieConstant.expire );
        return  ResultVOUtil.success ();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,HttpServletRequest request,HttpServletResponse response){
        //判断是否已登录
        Cookie cookie = CookiesUtil.get(request, CookieConstant.TOKEN);
        if( (cookie != null) &&
                !(StringUtils.isEmpty (stringRedisTemplate.opsForValue ().get (String.format (RedisConstant.TOKEN_TEMPLATE,cookie.getValue ()))))){
           return  ResultVOUtil.success ();
        }


        //1、openid 和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid (openid);
        if(  null == userInfo ){
            return ResultVOUtil.error (ResultEnum.LOGIN_FAIL);
        }

        //2、判断角色
        if(RoleEnum.SELLER.getCode () != userInfo.getRole ()){
            return  ResultVOUtil.error (ResultEnum.ROLE_ERROR);
        }

        //3、redis 设置key = UUID, value = xyz
        String token = UUID.randomUUID ().toString ();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue ().set (String.format (RedisConstant.TOKEN_TEMPLATE,token ),
               openid,
                expire,
                TimeUnit.SECONDS);

        //4、cookie 里设置token=UUID
        CookiesUtil.set (response,CookieConstant.TOKEN, token, CookieConstant.expire );
        return  ResultVOUtil.success ();
    }
}
