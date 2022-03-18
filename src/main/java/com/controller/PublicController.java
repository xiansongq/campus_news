package com.controller;

import com.daomain.Likes;
import com.daomain.Message;
import com.daomain.Myfile;
import com.daomain.News;
import com.service.PublicService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class PublicController {
    @Autowired
    Message message;
    @Autowired
    PublicService publicService;

    @RequestMapping("/findall")
    public Message test1(HttpServletRequest request){
        List<Map<String,String>> list=publicService.findAll();
        message.setFlag(1);
        message.setObject(list);
        request.getSession().setAttribute("category",list);
        return message;
    }

    @RequestMapping("/getcategory")

    public Message test2(HttpServletRequest request){

       message.setObject(request.getSession().getAttribute("category"));
       return message;
    }

    @RequestMapping("/selectall")
    public JSONObject test3(Integer page,Integer limit,String title,String author){
        JSONObject jsonObject = new JSONObject();
        // 设置分页相关参数   当前页+每页显示的条数
        //PageHelper.startPage(page, limit);

        List<News> list=publicService.select_all(title,author);
        List<News> list1=new ArrayList<>();

        for(int i=(page-1)*limit,j=1;i<list.size()&&j<=limit;++i,++j){

            list1.add(list.get(i));
        }
        //PageInfo<News> data = new PageInfo<News>(list1);
        jsonObject.put("data",list1);
        jsonObject.put("code",0);
        jsonObject.put("count",list.size());
        jsonObject.put("msg","数据请求成功！");

        return jsonObject;
    }

    @RequestMapping("/add_tourist")
    public void test4(String id){
          publicService.add_tourist(id);
    }


}
