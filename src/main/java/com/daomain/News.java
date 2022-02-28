package com.daomain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class News {
    String id, title, author, content, likes_number, collections_number, category_id,tourist_number;
    String fid, news_id, name, uuid, type, size, path;

    /* hh:mm:ss*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")//页面写入数据库时格式化
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")  //查询输出时格式转换
            Date time, ftime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLikes_number() {
        return likes_number;
    }

    public void setLikes_number(String likes_number) {
        this.likes_number = likes_number;
    }

    public String getCollections_number() {
        return collections_number;
    }

    public void setCollections_number(String collections_number) {
        this.collections_number = collections_number;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTourist_number() {
        return tourist_number;
    }

    public void setTourist_number(String tourist_number) {
        this.tourist_number = tourist_number;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", likes_number='" + likes_number + '\'' +
                ", collections_number='" + collections_number + '\'' +
                ", category_id='" + category_id + '\'' +
                ", tourist_number='" + tourist_number + '\'' +
                ", fid='" + fid + '\'' +
                ", news_id='" + news_id + '\'' +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                ", time=" + time +
                ", ftime=" + ftime +
                '}';
    }
}
