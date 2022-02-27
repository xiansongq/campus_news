package com.service.impl;

import com.daomain.News;
import com.mapper.Publicmapper;
import com.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("PublicService")
public class PublicServiceimpl implements PublicService {
    @Autowired
    Publicmapper mp;
    @Override
    public List<Map<String, String>> findAll() {
        return mp.findAll();
    }

    @Override
    public List<News> select_all(String title,String author) {
        return mp.select_all(title, author);
    }
}