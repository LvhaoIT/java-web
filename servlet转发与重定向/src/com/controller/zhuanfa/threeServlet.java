package com.controller.zhuanfa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class threeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("Three页面");
        //1.通过当前请求对象生成资源文件申请报告对象
        System.out.println("gogogo3");
        RequestDispatcher report = request.getRequestDispatcher("/four");
        report.forward(request, response);
        System.out.println("gogogo4");
    }
}
