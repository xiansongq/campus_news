package com.controller;

import com.daomain.Comment;
import com.daomain.Message;
import com.daomain.News;
import com.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class AppController {
    @Autowired
    Message message;
    @Autowired
    AppService appService;
    @RequestMapping("/index")
    public List<News> test1(){
        return appService.findall();
    }

    @RequestMapping("/getdeatil")
    public News test2(String id){
        return appService.select_id(id);
    }

    @RequestMapping("/bycid")
    public List<News> test3(String category_id){
        return appService.select_bycid(category_id);
    }

    @RequestMapping("/check_like")
    public Message test4(String id,String userid){
        message.setFlag(appService.likes(id, userid));
        return message;
    }
    @RequestMapping("/check_col")
    public Message test5(String id,String userid){
        message.setFlag(appService.cols(id, userid));
        return message;
    }
    @RequestMapping("/insert_comment")
    public Message test6(Comment comment){
        message.setFlag( appService.insert_coment(comment));
        return message;
    }
}
