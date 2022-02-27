package com.mapper;

import com.daomain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Usermapper {
    /*根据openid 查找用户*/
     User find_openid(String openid);
    /*用户登录*/
    User login(@Param("userid")String userid,@Param("password") String password);
    /*写入用户openid*/
    int add_openid(@Param("userid") String userid,@Param("openid") String openid );
    /*修改用户密码*/
    int modif_password(@Param("userid")String userid,@Param("oldpassword") String oldpassword,@Param("newpassword")String newpassword);

}
