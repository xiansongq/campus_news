package com.service;

import com.daomain.News;

import java.util.List;
import java.util.Map;

public interface PublicService {
    /*查询新闻分类列表*/
    List<Map<String,String>> findAll();
    /*新闻列表查询 关联文件*/
    List<News> select_all(String title,String author);
    /*新闻游览量加一*/
    int add_tourist(String id);
}
