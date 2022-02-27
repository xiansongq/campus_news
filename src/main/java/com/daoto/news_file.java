package com.daoto;

import com.daomain.Myfile;
import com.daomain.News;
import org.springframework.stereotype.Component;

@Component
public class news_file {
    News news;
    Myfile myfile;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Myfile getMyfile() {
        return myfile;
    }

    public void setMyfile(Myfile myfile) {
        this.myfile = myfile;
    }
}
