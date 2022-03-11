package com.service.impl;

import com.daomain.*;
import com.mapper.Adminmapper;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AdminService")
@Transactional(propagation= Propagation.REQUIRED)
public class AdminServiceimpl implements AdminService {
    @Autowired
    Adminmapper mp;
    @Override
    public Admin login(String userid, String password) {
        return mp.login(userid,password);
    }

    @Override
    public int upload_news(News news, Myfile myfile) {
        int flag;
        if(myfile==null) {
            return mp.upload_news(news);
        }
        else {
             int n=mp.upload_news(news); //insert 返回的是 受影响的行数
            System.out.println("id------"+news.getId());
            if(n==0) return 0;
            else
            {
                myfile.setNews_id(news.getId());   //ID已经返回
                flag= mp.save_file(myfile);
            }

        }
        return flag;
    }

    @Override
    public int delete_news(String id) {
        mp.delete_file(id);
        return mp.delete_news(id);
    }


    @Override
    public int add_user(User user) {
        return mp.add_user(user);
    }

    @Override
    public int delete_user(String userid) {
        return mp.delete_user(userid);
    }

    @Override
    public int reset_password(String userid) {
        return mp.reset_password(userid);
    }

    @Override
    public int update_user(User user) {
        return mp.update_user(user);
    }

    @Override
    public List<User> list_user(User user) {
        return mp.list_user(user);
    }

    @Override
    public List<Comment> comment_list(String news_id,String userid,String content) {
        return mp.comment_list(news_id,userid,content);
    }

    @Override
    public int delete_comment(String id) {
        return mp.delete_comment(id);
    }

    @Override
    public int add_campus_n(Campus_n campus_n) {
        return mp.add_campus_n(campus_n);
    }

    @Override
    public List<Campus_n> campus_list(String name, String gender, String motto) {
        return mp.campus_list(name, gender, motto);
    }

    @Override
    public int delete_elegant(String id) {
        return mp.delete_elegant(id);
    }

    @Override
    public int update_campus(Campus_n campus_n) {
        return mp.update_campus(campus_n);
    }

    @Override
    public int update_news(News news) {
        return mp.update_news(news);
    }

    @Override
    public int update_myfile(Myfile myfile) {
        return mp.update_myfile(myfile);
    }

    @Override
    public int insert_myfile(Myfile myfile) {
        return mp.save_file(myfile);
    }

    @Override
    public List<Feedback> feedback_list(String content) {
        return mp.feedback_list(content);
    }

    @Override
    public int delete_feed(String id) {
        return mp.delete_feed(id);
    }


}
