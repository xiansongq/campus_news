package com;

import com.daomain.News;
import com.daomain.User;
import com.daoto.news_file;
import com.mapper.Publicmapper;
import com.mapper.Usermapper;
import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CampusNewsApplicationTests {
    @Autowired
   private UserService mp;
    @Autowired
    private Publicmapper pmp;
    @Test
    void contextLoads() {
       User user= mp.login("123","123");
        System.out.println(user);
    }
    @Test
    void modif(){
        System.out.println(mp.modif_password("1","1234","123456"));
    }


    @Test
    void findall(){

        List<Map<String,String> > list =pmp.findAll();
        for (Map<String ,String> map:list){
            System.out.println(map.toString());
        }
    }
    @Test
    void select_news_file(){
        List<News> list=pmp.select_all("123","123");
        System.out.println(list.toString());
    }

    @Test
    void delete_file(){
        File file=new File("C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.4446219654733482911\\WEB-INF\\upload\\1962132c929f48088f5ab119a036f945.docx");
        if(file.delete()){
            System.out.println("success");

        }else
            System.out.println("error");
    }


}
