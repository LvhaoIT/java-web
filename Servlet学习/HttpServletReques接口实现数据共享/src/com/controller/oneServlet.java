package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/6
 * Time: 8:50
 */
public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.将数据添加到请求作用域中，作为共享数据
        request.setAttribute("key1", "hello world");
        //2。代替浏览器，向tomcat索要twoServlet来完成剩余任务
        request.getRequestDispatcher("/two").forward(request, response);
    }
}
