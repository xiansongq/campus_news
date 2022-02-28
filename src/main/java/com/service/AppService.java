package com.service;

import com.daomain.Comment;
import com.daomain.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppService {
    /*查询首页新闻列表*/
    List<News> findall();
    /*根据新闻ID查询新闻详细信息*/
    News select_id(String id);
    /*根据新闻分类 id查询新闻*/
    List<News> select_bycid(String category_id);
    /*根据新闻id 和用户id查询是否已经点赞*/
    int likes(@Param("id")String id, @Param("userid")String userid);
    /*根据新闻id 和用户id查询是否已经收藏*/
    int cols(@Param("id")String id,@Param("userid")String userid);
    /*添加评论*/
    int insert_coment(Comment comment);
}
