package com.daomain;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    String id,userid,password,create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
