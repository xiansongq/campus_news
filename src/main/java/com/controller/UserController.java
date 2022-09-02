package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.daomain.Message;
import com.daomain.User;
import com.service.UserService;
import com.service.impl.UserServiceimpl;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
    /*修改密码*/
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


    private static RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }


    @RequestMapping("/getopenid")
    public Message test5(String code){
        System.out.println(code);
        String appid = "wx1fc218d22639ab25";
        //String secret="";  //小程序密钥
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        System.out.println(requestUrl);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //header.set("Authorization", "APPCODE " + appcode);
        //添加请求头
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(header);
        //发送post请求
        ResponseEntity<String> response = null;
        try {
            response = restTemplate().postForEntity(requestUrl, request, String.class);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        //System.out.println(response);
        JSONObject json=JSONObject.parseObject(response.getBody().toString());
        String openid= (String) json.get("openid");
        System.out.println(openid);
        if(openid!=null){
            message.setFlag(1);
            message.setMessage(openid);
        }else{
            message.setFlag(0);

        }

        return message;
    }
}
