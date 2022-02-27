package com.service.impl;

import com.daomain.User;
import com.mapper.Usermapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceimpl implements UserService {
    @Autowired
    Usermapper mp;

    @Override
    public User find_openid(String openid) {
        return mp.find_openid(openid);
    }

    @Override
    public User login(String userid, String password) {
        return mp.login(userid,password);
    }

    @Override
    public int add_openid(String userid, String openid) {
         return mp.add_openid(userid,openid);
    }

    @Override
    public int modif_password(String userid, String oldpassword, String newpassword) {
        return mp.modif_password(userid,oldpassword,newpassword);
    }
}
