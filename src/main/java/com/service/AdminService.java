package com.service;

import com.daomain.*;

import java.util.List;

public interface AdminService {
    /*登录*/
    Admin login(String userid, String password);
    /*发布新闻*/
    int upload_news(News news, Myfile myfile);
    /*删除新闻及其附件*/
    int delete_news(String id);

    /*添加用户*/
    int add_user(User user);
    /*删除用户*/
    int delete_user(String userid);
    /*重置用户密码*/
    int reset_password(String  userid);
    /*修改用户信息*/
    int update_user(User user);
    /*搜索用户信息*/
    List<User> list_user(User user);
    /*根据ID查询评论*/
    List<Comment> comment_list(String news_id,String userid,String content);
    /*删除评论*/
    int delete_comment(String id);
    /*添加风采人物*/
    int add_campus_n(Campus_n campus_n);

    /*查询风采人物*/
    List<Campus_n> campus_list(String name,String gender,String motto);
    /*删除风采人物*/
    int delete_elegant(String id);
    /*修改风采人物信息*/
    int update_campus(Campus_n campus_n);
    /*更新新闻数据*/
    int update_news(News news);

    /*更新对应的文件信息*/
    int update_myfile(Myfile myfile);

    /*上传文件*/
    int insert_myfile(Myfile myfile);
    /*查询反馈列表*/
    List<Feedback> feedback_list(String content);
    /*根据反馈ID删除反馈列表*/
    int delete_feed(String id);


}
