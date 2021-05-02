package com.demo01.controller.Response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String url = "http://www.baidu.com";
        response.sendRedirect(url);// 通过响应对象，将地址赋值给响应头中location属性

    }
}
