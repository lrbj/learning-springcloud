package com.imooc.user.repository;

import com.imooc.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:08 PM 8/22/2018
 */
public interface UserInfoRepostory extends JpaRepository<UserInfo, String> {
    UserInfo findByOpenid(String openid);
}
