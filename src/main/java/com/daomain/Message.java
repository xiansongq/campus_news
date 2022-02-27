package com.daomain;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private Integer flag; // 记录操作数据库的状态
    private String message; // 记录消息
    private Object object;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Message{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
