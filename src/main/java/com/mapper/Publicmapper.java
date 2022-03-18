package com.mapper;

import com.daomain.Likes;
import com.daomain.Myfile;
import com.daomain.News;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Publicmapper {

    /*查询所有新闻类别*/
   List< Map<String,String> > findAll();
   /*查询新闻列表*/
    List<News> select_all(@Param("title") String title,@Param("author") String author);
    /*新闻游览量加一*/
    int add_tourist(String id);

}
