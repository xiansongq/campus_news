package com.controller;

import cn.hutool.http.HtmlUtil;
import com.daomain.*;
import com.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    Message message;
    @Autowired
    AdminService adminService;

    @RequestMapping("/checkcode")

    public void test1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        // 在内存中创建一个长80，宽30的图片，默认黑色背景
        // 参数一：长
        // 参数二：宽
        // 参数三：颜色
        int width = 80;
        int height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取画笔
        Graphics g = image.getGraphics();
        // 设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        // 填充图片
        g.fillRect(0, 0, width, height);

        // 产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        // 将验证码放入HttpSession中
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        // 设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        // 设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        // 向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        // 将内存中的图片输出到浏览器
        // 参数一：图片对象
        // 参数二：图片的格式，如PNG,JPG,GIF
        // 参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            // 产生0到size-1的随机值
            int index = r.nextInt(size);
            // 在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            // 将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    /*管理员登录*/
    @RequestMapping("/login")
    public Message test2(String username, String password, String captcha, HttpServletRequest request) {

        //获取验证码session
        String code = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        /*转为小写*/
        code = code.toLowerCase();
        captcha = captcha.toLowerCase();
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(code);
//        System.out.println(captcha);
        Admin admin = adminService.login(username, password);
        int flag = code.compareTo(captcha);
        if (flag == 0 && admin != null) {
            message.setFlag(1);
            message.setObject(admin);
            request.getSession().setAttribute("user",admin);
        } else
            message.setFlag(0);
        return message;
    }

    @RequestMapping("/upload")
    public Message test3(MultipartFile file, @Param("titile") String title, @Param("author") String author,
                         @Param("category_id") String category_id, @Param("content") String content,
                         HttpServletRequest request
    ) {

        /*防止xss攻击进行html转义*/
        title= HtmlUtil.filter(title);
        author=HtmlUtil.filter(author);


        News news = new News();
        Myfile myfile = new Myfile();
        System.out.println(file);
        if (file != null) {
            //生成uuid 为新的文件名

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String name = file.getOriginalFilename();
            String type = name.substring(name.lastIndexOf(".") + 1);
            String size = String.valueOf(file.getSize());
            String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");

//            System.out.println(name);
//            System.out.println(type);
//            System.out.println(size);
//            System.out.println(type);
            //保存目录
            File filepath = new File(savePath);
            //目录不存在 创建目录
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            //文件真是存储路径
            String path = savePath + File.separator + uuid + "." + type;
            //System.out.println(path);
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                message.setFlag(0);
                message.setMessage("文件上传失败！");
                return message;
            }

            myfile.setName(name);
            myfile.setUuid(uuid);
            myfile.setPath(path);
            myfile.setSize(size);
            myfile.setType(type);

        } else {
            myfile = null;
        }
        news.setAuthor(author);
        news.setCategory_id(category_id);
        news.setContent(content);
        news.setTitle(title);
        int flag = newsupload(news, myfile);
        if (flag != 0) {
            message.setFlag(1);
        } else
            message.setFlag(0);
        return message;
    }

    public int newsupload(News news, Myfile myfile) {
        return adminService.upload_news(news, myfile);
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("/delete_news")
    public Message test4(String id) {
        int flag = adminService.delete_news(id);
        if (flag == 1) {
            message.setFlag(1);
            message.setMessage("删除成功！");
        } else {
            message.setFlag(0);
            message.setMessage("删除失败！");
        }
        return message;
    }

    /**
     * 批量删除 新闻
     *
     * @param id
     * @return
     */

    @RequestMapping("/batch_delete")
    public Message test5(String id[]) {
        int flag = 0;
        for (String s : id) {
            flag = adminService.delete_news(s);
            if (flag == 0) {
                message.setFlag(0);
                return message;
            }
        }
        message.setFlag(1);
        return message;
    }

    @RequestMapping("/getfile")
    public Message test6(String path, String name, HttpServletResponse response) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            message.setFlag(0);
            message.setMessage("你要下载的资源已经被删除！");
            return message;

        }
        //设置响应头，控制浏览器下载该文件 并将文件还原为原始的名称
        try {
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//读取要下载的文件，保存到文件输入流
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            message.setFlag(0);
            message.setMessage("下载失败！");
            return message;
        }
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
        //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
        message.setFlag(1);
        return message;
    }

    @RequestMapping("/user_list")
    public JSONObject test7(User user,Integer limit,Integer page){
        JSONObject jsonObject = new JSONObject();
        System.out.println(user.toString());
        List<User> list =adminService.list_user(user);
        List<User> list1=new ArrayList<>();

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

    @RequestMapping("/add_user")
    public Message test8(User user){

        //xss 过滤
        user.setUserid(HtmlUtil.filter(user.getUserid()));
        user.setName(HtmlUtil.filter(user.getName()));

        int flag=adminService.add_user(user);
        if(flag==0)
            message.setFlag(0);
        else
            message.setFlag(1);
        return message;
    }

    @RequestMapping("/batch_deleteuser")
    public Message test9(String userid[]){
        int flag;
        for (String s : userid) {
            flag=adminService.delete_user(s);
            if(flag==0){
                message.setFlag(0);
                return message;
            }
        }
        message.setFlag(1);
        return message;
    }
    @RequestMapping("/reset_password")
    public Message test10(String userid){
         int flag=adminService.reset_password(userid);
         if(flag==1)
             message.setFlag(1);
         else
             message.setFlag(0);
         return message;
    }
    @RequestMapping("/update_user")
    public Message test11(User user){
        //xss 过滤
        user.setUserid(HtmlUtil.filter(user.getUserid()));
        user.setName(HtmlUtil.filter(user.getName()));

        int flag=adminService.update_user(user);
        if(flag==1)
            message.setFlag(1);
        else
            message.setFlag(0);
        return message;
    }

    @RequestMapping("/comment_list")
    public JSONObject test12(String news_id,String userid,String content,Integer limit,Integer page){
        JSONObject jsonObject = new JSONObject();

        List<Comment> list =adminService.comment_list(news_id,userid,content);
        List<Comment> list1=new ArrayList<>();

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

    @RequestMapping("/delete_comment")
    public Message test13(String id[]){
        int flag;
        for (String s : id) {
            flag=adminService.delete_comment(s);
            if(flag==0){
                message.setFlag(0);
                return message;
            }
        }
        message.setFlag(1);
        return message;
    }

    @RequestMapping("/add_campus_n")
    public Message test14(Campus_n campus_n){
        /*防止xss攻击进行html转义*/
        campus_n.setName(HtmlUtil.filter(campus_n.getName()));
        campus_n.setMotto(HtmlUtil.filter(campus_n.getMotto()));
//        campus_n.setElegant(HtmlUtil.filter(campus_n.getElegant()));
        campus_n.setResume(HtmlUtil.filter(campus_n.getResume()));

        int flag=adminService.add_campus_n(campus_n);
        if(flag==1)
            message.setFlag(1);
        else
            message.setFlag(0);
        return message;
    }

    @RequestMapping("/campus_list")
    public JSONObject test15(String name,String gender,String motto,Integer limit,Integer page){
        JSONObject jsonObject = new JSONObject();

        List<Campus_n> list =adminService.campus_list(name,gender,motto);
        List<Campus_n> list1=new ArrayList<>();

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

    @RequestMapping("/delete_elegant")
    public Message test16(String id[]){
        int flag=1;
        for (String s : id) {
            flag=adminService.delete_elegant(s);
            if(flag==0){
                message.setFlag(0);
                return message;
            }

        }
        message.setFlag(1);
        return message;
    }

    @RequestMapping("/update_elegant")
    public Message test17(Campus_n campus_n){
        /*防止xss攻击进行html转义*/
        campus_n.setName(HtmlUtil.filter(campus_n.getName()));
        campus_n.setMotto(HtmlUtil.filter(campus_n.getMotto()));

        campus_n.setResume(HtmlUtil.filter(campus_n.getResume()));

        int flag=adminService.update_campus(campus_n);
        message.setFlag(flag);
        return message;
    }


    /**
     * 这里逻辑性很强 可以好好看看
     * @param file
     * @param id
     * @param fid
     * @param oldpath
     * @param title
     * @param author
     * @param category_id
     * @param content
     * @param request
     * @return
     */
    @RequestMapping("/update_news")
    public Message test18(MultipartFile file,@Param("id") String id, @Param("fid") String fid,@Param("oldpath") String oldpath,@Param("titile") String title, @Param("author") String author,
                         @Param("category_id") String category_id, @Param("content") String content,
                         HttpServletRequest request
    ) {


        /*防止xss攻击进行html转义*/
        title= HtmlUtil.filter(title);
        author=HtmlUtil.filter(author);


        //用来记录原文件是否为空
        boolean oldflag=false;
        News news = new News();
        Myfile myfile = new Myfile();

        if (file != null) {
            System.out.println(oldpath);
            //原文件不空的情况下
            if(oldpath!=null&&"".equals(oldpath)==false&&"null".equals(oldpath)==false){
                oldflag=true;
                //删除原文件
                File file1=new File(oldpath);


                if(file1.delete()){

                }else {
                    message.setFlag(0);
                    System.out.println("原文件删除失败！");
                    return message;
                }

            }else{
                oldflag=false;
            }

            //生成uuid 为新的文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String name = file.getOriginalFilename();
            String type = name.substring(name.lastIndexOf(".") + 1);
            String size = String.valueOf(file.getSize());
            String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");


            //保存目录
            File filepath = new File(savePath);
            //目录不存在 创建目录
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            //文件真是存储路径
            String path = savePath + File.separator + uuid + "." + type;
            System.out.println(path);
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                message.setFlag(0);
                message.setMessage("文件上传失败！");
                return message;
            }


            myfile.setName(name);
            myfile.setUuid(uuid);
            myfile.setPath(path);
            myfile.setSize(size);
            myfile.setType(type);

        } else {
            myfile = null;
        }

        news.setAuthor(author);
        news.setCategory_id(category_id);
        news.setContent(content);
        news.setTitle(title);
        news.setId(id);

        System.out.println("fid"+fid);
        int flag1=0,flag2=0;
        //原文件不空的情况  且上传了新文件
        if(oldflag&&myfile!=null){
            System.out.println(1);
            myfile.setId(fid);
            //更新文件信息即可
            flag1=adminService.update_myfile(myfile);

            flag2 = adminService.update_news(news);
        }

        //原文件为空 但是上传了新文件
        else if(oldflag==false&&myfile!=null){
            System.out.println(2);
            // 直接上传新文件就好
            myfile.setNews_id(news.getId());
             flag1=  adminService.update_news(news);   //更新新闻信息
            flag2 = adminService.insert_myfile(myfile);  //上传文件
        }
        //原文件不空  没有上传文件
        else if(oldflag&&myfile==null){
            System.out.println(3);

            flag2 = adminService.update_news(news);
        }
        //原文件为空 也没有上传文件
        else if(oldflag==false&&myfile==null){
            System.out.println(3);
            flag2 = adminService.update_news(news);
        }


        if (flag1 != 0||flag2!=0) {
            message.setFlag(1);
        } else
            message.setFlag(0);
        return message;
    }


    /**
     * 查询 feedback
     * @param content
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/feedback_list")
    public JSONObject test19(String content,Integer limit,Integer page){
        JSONObject jsonObject = new JSONObject();

        List<Feedback> list =adminService.feedback_list(content);
        List<Feedback> list1=new ArrayList<>();

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

    /**
     * 删除 feedback 数据
     * @param id
     * @return
     */
    @RequestMapping("/delete_feed")
    public Message test20(String id[]){
        int flag;
        for (String s : id) {
            flag=adminService.delete_feed(s);
            if(flag==0){
                message.setFlag(0);
                return message;
            }
        }
        message.setFlag(1);
        return message;
    }



}
