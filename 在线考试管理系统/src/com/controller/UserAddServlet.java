package com.controller;

import com.Dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //请求对象字符集
        request.setCharacterEncoding("utf-8");
        //响应对象 输出方式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.调用请求对象读取请求头
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        System.out.println(userName + "  " + password + "  " + sex + "  " + email);
        //2.调用userDao将用户信息填充到insert命令并借助jdbc规范发送到数据库服务器中
        int result = new UserDao().add(new Users(userName, password, sex, email));

        //3.调用响应对象将处理结果以二进制形式写入到响应体中
        if (result == 1)
            out.println("<font style='color:read;font-size:40'>用户注册成功！</font>");
        else
            out.println("<font style='color:gree;font-size:40'>用户注册失败！</font>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("OneServlet类针对浏览器发送POST请求方式处理");
    }
}
