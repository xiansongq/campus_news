package com.mapper;

import com.daomain.Campus_n;
import com.daomain.Comment;
import com.daomain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Appmapper {

    /*查询首页新闻列表*/
    List<News> findall();
    /*根据新闻ID查询新闻详细信息*/
    News select_id(String id);

    /*根据新闻分类 id查询新闻*/
    List<News> select_bycid(String category_id);

    /*根据新闻id 和用户id查询是否已经点赞*/
    int likes(@Param("id")String id,@Param("userid")String userid);
    /*根据新闻id 和用户id查询是否已经收藏*/
    int cols(@Param("id")String id,@Param("userid")String userid);

    /*添加评论*/
    int insert_coment(Comment comment);
    /*根据新闻ID查询 评论列表*/
    List<Comment> comment_list(String news_id);
    /**/
    /*收藏文章*/
    int insert_col(@Param("news_id")String news_id,@Param("userid")String userid);

    /*点赞文章*/
    int insert_likes(@Param("news_id")String news_id,@Param("userid")String userid);

    /*取消收藏文章*/
    int delete_col(@Param("news_id")String news_id,@Param("userid")String userid);

    /*取消点赞文章*/
    int delete_likes(@Param("news_id")String news_id,@Param("userid")String userid);
    /*新闻点赞数加1*/
    int add_likes(String news_id);
    /*新闻收藏数加1*/
    int add_col(String news_id);
    /*新闻点赞数加1*/
    int sub_likes(String news_id);
    /*新闻收藏数加1*/
    int sub_col(String news_id);

    /*查询收藏新闻列表*/
    List<News> collection_list(String userid);
    /*查询风采人物列表*/
    List<Campus_n> campus_list();
    /*根据ID 获取人物信息*/
    Campus_n findby_id(String id);

    /*添加反馈记录*/
    int add_feedback(String content);

    /*清除用户授权信息*/
    int cleanOpenid(String userid);

}
