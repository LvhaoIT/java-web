package com.demo01.controller.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestServlet03")
public class RequestServlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通知请求体，获得一个utf-8的字符集
        request.setCharacterEncoding("utf-8");
        //通过请求对象，读取【请求体】中的数据
        String password = request.getParameter("password");
        System.out.println("从请求体中得到的password数据： " + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过请求对象，读取【请求头】参数信息
        String username = request.getParameter("username");
        System.out.println("从请求头中得到的username数据： " + username);
    }
}
