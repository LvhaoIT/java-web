package com.controller.chongdingxiang;

import java.io.IOException;

public class oneServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("gogogo1");
        //重定向
        response.sendRedirect("/servlet/two");
        System.out.println("gogogo2");
    }
}
