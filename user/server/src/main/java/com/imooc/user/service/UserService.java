package com.imooc.user.service;

import com.imooc.user.dataobject.UserInfo;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:11 PM 8/22/2018
 */
public interface UserService {
    /**
     *查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
