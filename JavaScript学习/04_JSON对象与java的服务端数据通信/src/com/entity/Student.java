package com.entity;

import java.sql.PreparedStatement;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 10:56
 */
public class Student {
    private  Integer stuId;
    private  String stuName;

    public Student() {
    }

    public Student(Integer stuId, String stuName) {
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
