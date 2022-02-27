package com.mapper;

import com.daomain.Myfile;
import com.daomain.News;
import com.daoto.news_file;
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
}
