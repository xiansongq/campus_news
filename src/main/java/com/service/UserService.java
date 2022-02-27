package com.service;

import com.daomain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /*根据 openid查找用户*/
    User find_openid(String openid);
    /*用户登录*/
    User login(String userid ,String password);
    /*写入 openid*/
    int add_openid(String userid,String openid);
    /*修改用户密码*/
    int modif_password(@Param("userid")String userid, @Param("oldpassword") String oldpassword, @Param("newpassword")String newpassword);

}
