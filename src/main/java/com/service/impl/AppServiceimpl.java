package com.service.impl;

import com.daomain.Comment;
import com.daomain.News;
import com.mapper.Appmapper;
import com.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AppService")
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
}
