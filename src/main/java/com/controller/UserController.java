package com.controller;

import com.daomain.Message;
import com.daomain.User;
import com.service.UserService;
import com.service.impl.UserServiceimpl;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;
    @Autowired
    private Message message;
    /* 根据openid 查找用户 */
    @RequestMapping("/find_openid")
    public Message  test1(String openid, HttpServletRequest request){
        User user= userService.find_openid(openid);
        if(user!=null) {
            message.setFlag(1);
            message.setObject(user);
            request.getSession().setAttribute("user",user);
        }else
        {
            message.setFlag(0);
            message.setMessage("该用户第一次登录，其输入账号密码登录！");
        }
        return message;

    }

    /*用户登录*/
    @RequestMapping("/login")
    public Message  test2(String userid,String password,String openid,HttpServletRequest request){
        User user =userService.login(userid,password);
        if(user!=null){
            int flag2=userService.add_openid(userid,openid);
            if(flag2==1){

                message.setFlag(1);
                request.getSession().setAttribute("user",user);
                message.setObject(user);
            }else {
                message.setFlag(0);
            }
        }
        else {
            message.setFlag(0);
        }
        return message;
    }
    /*用户登录*/
    @RequestMapping("/modif")
    @ResponseBody()
    public Message test3(@RequestBody JSONObject jsonObject){
        String userid=jsonObject.get("userid").toString();
        String oldpassword=jsonObject.get("oldpassword").toString();
        String newpassword=jsonObject.get("newpassword").toString();

        int flag=userService.modif_password(userid,oldpassword,newpassword);

        if(flag == 1){
            message.setFlag(1);
        }
        else
        { message.setFlag(0);
        }
         return message;
    }
    @RequestMapping("/hello")
    public String test4(){
        return "Hello word!";
    }
}
