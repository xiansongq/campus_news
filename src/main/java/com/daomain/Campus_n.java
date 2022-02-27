package com.daomain;

import org.springframework.stereotype.Component;

@Component
public class Campus_n {
    String id,name,gender,resume,motto,elegant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getElegant() {
        return elegant;
    }

    public void setElegant(String elegant) {
        this.elegant = elegant;
    }

    @Override
    public String toString() {
        return "Campus_n{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", resume='" + resume + '\'' +
                ", motto='" + motto + '\'' +
                ", elegant='" + elegant + '\'' +
                '}';
    }
}
