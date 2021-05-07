package com.controller;

import com.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象对请求体使用utf-8字符集
        request.setCharacterEncoding("utf-8");
        //2.调用请求对象读取请求体参数信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //3.调用dao将查询验证信息推送到数据库服务器上
        int flag = new UserDao().login(userName, password);
        //4、调用响应对象，根据验证结果将不同资源文件写入到响应头中
        if (flag == 1) {
            //用户存在，合法用户，纷发令牌
            HttpSession session = request.getSession();
            response.sendRedirect("/demo1/index.html");
        } else {
            response.sendRedirect("/demo1/login_error.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
