package com;

import com.entity.Student;
import com.util.ReflectUitl;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 22:50
 */
public class Test {
    public static void main(String[] args) {
        Student stu = new Student(1,"hsy");
        String str = new ReflectUitl().jsonObject(stu);
        System.out.println(str);
    }
}
