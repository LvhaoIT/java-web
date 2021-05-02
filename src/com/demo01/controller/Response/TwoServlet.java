package com.demo01.controller.Response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TwoServlet extends HttpServlet {
    public TwoServlet() {
        System.out.println("TwoServlet已经被创建！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("TwoServlet的Post方法");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("utf-8"); // 1
        response.setContentType("text/html;charset=utf-8"); // 2
        response.setCharacterEncoding("utf-8"); // 3

        System.out.println("TwoServlet的Get方法");
        int money = 97;
        PrintWriter out = response.getWriter();
        out.write(money);
        /**
         * out.writer方法可以将 【字符，字符串，ASCII码】 写入到响应体
         * 
         */
        out.println("猪头头华思烨");
        // out.printf()可以将各种类型的输出到服务器中(常用)
    }
}
