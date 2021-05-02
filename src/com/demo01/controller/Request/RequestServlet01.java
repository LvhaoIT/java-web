package com.demo01.controller.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestServlet01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        // 通过请求对象，读取【请求行】中 url 信息
        String url = request.getRequestURL().toString();
        // 通过请求对象，读取【请求行】中 method 信息
        String method = request.getMethod();
        // 通过请求对象，读取【请求行】中 uri信息
        String uri = request.getRequestURI();
        /**
         * 什么是uri：资源文件精准定位地址，在请求行没有uri这个属性
         *           实际上是从URL中截取一个字符串，这个字符串格式 “/网站名/资源文件名 ”
         *          URI用于让Http服务器对被访问的资源文件进行定位
         */

        PrintWriter out = response.getWriter();
        out.print("URL: " + url + "<br>" + "Method: " + method + "<br>URI: " + uri);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
