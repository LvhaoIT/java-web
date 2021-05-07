package com.controller;

import com.Dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应对象
        response.setContentType("text/html;charset=utf-8");
        //请求对象
        request.setCharacterEncoding("utf-8");

        //调用UserDao
        List<Users> list = new UserDao().find();

        //输出所有
        PrintWriter out = response.getWriter();
        //索要令牌，排除非法用户

        //if (request.getSession(false) != null) {//如果当前用户拥有session则返回对象，否则返回null
        //以表格形式输出
        out.println(" <table border='2' align='center'>");
        out.println("<tr> <td>id </td><td>name</td><td>password</td><td>sex</td><td>email</td><td>操作</td></tr>");
        for (Users e : list) {
            out.println("<tr>" + "<td>" + e.getUserId() + "</td>" + "<td>" + e.getUserName() + "</td>" + "<td>" + e.getPassword() + "</td>" + "<td>" + e.getSex() + "</td>" + "<td>" + e.getEmail() + "</td>");
            out.println("<td><a href='/demo1/user/delete?userId=" + e.getUserId() + "'>删除用户 &nbsp &nbsp");
            out.println("<a href='/demo1/user/update?userId=" + e.getUserId() + "'>修改用户</td>");
            out.println("</tr>");
        }
        out.println(" </table>");
        // } else {
        //   response.sendRedirect("/demo1/login_error.html");//非法用户直接送走
        //  return;
        // }
    }
}
