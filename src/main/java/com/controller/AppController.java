package com.controller;

import cn.hutool.http.HtmlUtil;
import com.daomain.Campus_n;
import com.daomain.Comment;
import com.daomain.Message;
import com.daomain.News;
import com.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        System.out.println(message.getFlag());
        return message;
    }
    @RequestMapping("/insert_comment")

    public Message test6(@RequestBody Comment comment){

//        Comment comment=new Comment();
//        comment.setNews_id(news_id);
//        comment.setUserid(userid);
//        comment.setContent(content);
        message.setFlag( appService.insert_coment(comment));
        return message;
    }


    /**
     * @param news_id
     * @return  返回全部评论数据
     */
    @RequestMapping("/comment_list")
    public List<Comment> test7(String news_id){
        return appService.comment_list(news_id);
    }

    @RequestMapping("/insert_col")
    public Message test8(String news_id,String userid){
        message.setFlag(appService.insert_col(news_id, userid));
        return message;
    }
    @RequestMapping("/insert_likes")
    public Message test9(String news_id,String userid){
        message.setFlag(appService.insert_likes(news_id, userid));
        return message;
    }

    @RequestMapping("/delete_col")
    public Message test10(String news_id,String userid){
        message.setFlag(appService.delete_col(news_id, userid));
        return message;
    }
    @RequestMapping("/delete_likes")
    public Message test11(String news_id,String userid){
        message.setFlag(appService.delete_likes(news_id, userid));
        return message;
    }

    /**
     * @param news_id
     * @return  返回最新的十条评论
     */
    @RequestMapping("/comment_ten")
    public List<Comment> test12(String news_id){
        List<Comment> list=appService.comment_list(news_id);
        List<Comment> list1=new ArrayList<>();
        if(list.size()<=10) return list;
        else{
            for(int i=0;i<10;++i)
                list1.add(list.get(i));
        }
        return list1;
    }

    /**
     * @param userid
     * @return  返回用户收藏的数据列表
     */
    @RequestMapping("/col_list")
    public List<News> test13(String userid){
        return appService.collection_list(userid);
    }

    /**
     * @return 返回风采人物列表
     */
    @RequestMapping("/campus_list")
    public List<Campus_n> test14(){
        return appService.campus_list();
    }

    @RequestMapping("/findby_id")

    public Campus_n test15(String  id){
        return appService.findby_id(id);
    }

    @RequestMapping("add_feedback")
    public Message test16( String content){
        //xss 攻击过滤
        content= HtmlUtil.filter(content);
        message.setFlag(appService.add_feedback(content));
        return message;
    }

    @RequestMapping("/cleanOpenid")
    public Message test17(String userid){
        int flag=appService.cleanOpenid(userid);
        if (flag==1) {
            message.setFlag(1);
            message.setMessage("清除成功!");
        }else{
            message.setFlag(0);
            message.setMessage("清除失败！");
        }
        return message;
    }

}
