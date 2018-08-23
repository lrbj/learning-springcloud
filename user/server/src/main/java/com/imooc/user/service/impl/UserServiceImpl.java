package com.imooc.user.service.impl;

import com.imooc.user.dataobject.UserInfo;
import com.imooc.user.repository.UserInfoRepostory;
import com.imooc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:12 PM 8/22/2018
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepostory  userInfoRepostory;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepostory.findByOpenid (openid);
    }
}
