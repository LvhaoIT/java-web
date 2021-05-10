package com.controller;

import com.entity.Stu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/9
 * Time: 17:14
 */
public class oneServlet extends HttpServlet {
    /**
     * 处理业务，得到处理结果--查询学员信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List stuList = new ArrayList();
        stuList.add(new Stu(10, "mike"));
        stuList.add(new Stu(20, "hsy"));

        //添加到请求作用域对象中
        request.setAttribute("key", stuList);

        //通过请求转发方案，向tomcat申请调用user_show.jsp
        //同时将request与response通过tomcat交给user_show.jsp使用
        request.getRequestDispatcher("/user_show.jsp").forward(request, response);
    }
}
