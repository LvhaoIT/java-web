package com.controller.User;

import com.Dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserUpdataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取需要修改的id
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        Users user = new UserDao().findOne(userId);//获取对应对象
        HttpSession session = request.getSession();//索要session
        session.setAttribute("upUser", user);//传入参数
        //请求转发
        request.getRequestDispatcher("/Update.jsp").forward(request, response);


    }
}
