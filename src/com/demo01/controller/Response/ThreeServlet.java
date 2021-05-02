package com.demo01.controller.Response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String str = "Java<br>MySQL<br>HTML<br>";
        String str1 = "红烧猪蹄<br>糖醋里脊<br>炸鸡啤酒";

        // 设置响应头content-type
        response.setContentType("text/html;charset=utf-8");
        // 向Tomcat索要输出流
        PrintWriter out = response.getWriter();
        // 通过输出流将结果写入到响应体
        out.println(str);
        out.println(str1);

    }
}
