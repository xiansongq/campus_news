package com.mapper;

import com.daomain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Adminmapper {
    /*登录*/
    Admin login(@Param("userid") String userid, @Param("password") String password);

    /*发布新闻*/
    int upload_news(News news);

    /*文件信息保存*/
    int save_file(Myfile myfile);

    /*删除新闻*/
    int delete_news(String id);

    /*删除新闻的的附件*/
    int delete_file(String news_id);

    /*添加用户*/
    int add_user(User user);

    /*删除用户*/
    int delete_user(String userid);

    /*重置用户密码*/
    int reset_password(String  userid);

    /*修改用户信息*/
    int update_user(User user);

    /*搜索用户信息  查询用户列表*/
    List<User> list_user(User user);

    /*根据ID查询评论*/
    List<Comment> comment_list(@Param("news_id") String news_id,@Param("userid") String userid,@Param("content") String content);

    /*删除评论*/
    int delete_comment(String id);

    /*添加风采人物*/
    int add_campus_n(Campus_n campus_n);

    /*查询风采人物*/
    List<Campus_n> campus_list(@Param("name")String name,@Param("gender")String gender,@Param("motto")String motto);

    /*删除风采人物*/
    int delete_elegant(String id);

    /*修改风采人物信息*/
    int update_campus(Campus_n campus_n);

    /*更新新闻数据*/
    int update_news(News news);

    /*更新对应的文件信息*/
    int update_myfile(Myfile myfile);






}
