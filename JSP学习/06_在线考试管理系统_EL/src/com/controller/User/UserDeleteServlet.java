package com.controller.User;

import com.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.取出数据
        String userId = request.getParameter("userId");
        //2.调用Dao处理
        int result = new UserDao().delete(userId);
        //3判断是否成功
        if (result == 1) {
            out.println("<p1 style='color: brown; font-size: 30px;'>");
            out.println("编号为：" + userId + "数据删除成功！");
            out.println("</p1>");
        } else {
            out.println("<p1 style='color: gree; font-size: 30px;'>");
            out.println("编号为：" + userId + "数据失败！");
        }

    }
}
