package com.service.impl;

import com.daomain.Campus_n;
import com.daomain.Comment;
import com.daomain.News;
import com.mapper.Appmapper;
import com.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AppService")
@Transactional(propagation= Propagation.REQUIRED)
public class AppServiceimpl implements AppService {

    @Autowired
    private Appmapper appmapper;
    @Override
    public List<News> findall() {
        return appmapper.findall();
    }

    @Override
    public News select_id(String id) {
        return appmapper.select_id(id);
    }

    @Override
    public List<News> select_bycid(String category_id) {
        return appmapper.select_bycid(category_id);
    }

    @Override
    public int likes(String id, String userid) {
        return appmapper.likes(id, userid);
    }

    @Override
    public int cols(String id, String userid) {
        return appmapper.cols(id, userid);
    }

    @Override
    public int insert_coment(Comment comment) {
        return appmapper.insert_coment(comment);
    }

    @Override
    public List<Comment> comment_list(String news_id) {
        return appmapper.comment_list(news_id);
    }

    @Override
    public int insert_col(String news_id, String userid) {
        return appmapper.insert_col(news_id,userid)& appmapper.add_col(news_id);
    }

    @Override
    public int insert_likes(String news_id, String userid) {
        return appmapper.insert_likes(news_id,userid)&appmapper.add_likes(news_id);
    }

    @Override
    public int delete_col(String news_id, String userid) {

        return appmapper.delete_col(news_id, userid)&appmapper.sub_col(news_id);
    }

    @Override
    public int delete_likes(String news_id, String userid) {
        return appmapper.delete_likes(news_id, userid)&appmapper.sub_likes(news_id);
    }

    @Override
    public List<News> collection_list(String userid) {
        return appmapper.collection_list(userid);
    }

    @Override
    public List<Campus_n> campus_list() {
        return appmapper.campus_list();
    }

    @Override
    public Campus_n findby_id(String id) {
        return appmapper.findby_id(id);
    }

    @Override
    public int add_feedback(String content) {
        return appmapper.add_feedback(content);
    }

}
