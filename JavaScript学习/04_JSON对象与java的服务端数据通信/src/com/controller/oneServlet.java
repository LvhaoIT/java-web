package com.controller;

import com.entity.Student;
import com.util.ReflectUitl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 10:58
 */
public class oneServlet extends HttpServlet {
    //对get方法进行处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student stu = new Student(1,"hsy"); //这种传值是错误的，高级类型传的是内存地址
       // String stu ="{\"stuId\":10,\"stuName\":\"hsy\"}";
        //转换为json格式
        String json =  ReflectUitl.jsonObject(stu);
        //放入请求作用域对象
        request.setAttribute("key",json);
        //转到jsp运行
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
