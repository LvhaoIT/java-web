package com.controller.User;

import com.Dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/10
 * Time: 0:17
 */
public class UserUpdateServlet_2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求对象字符集
        request.setCharacterEncoding("utf-8");
        //响应对象 输出方式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.调用请求对象读取请求头
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        Users user = new Users(userId, userName, password, sex, email);
        int result = new UserDao().update(user);

        if (result == 1) {
            out.println("<font style='color:red; font-size:40px'>修改成功！</font>");
        } else {
            out.println("<font style='color:red; font-size:40px'>修改失败！</font>");
        }

        //销毁数据
        HttpSession session = request.getSession();
        session.removeAttribute("upUser");

    }
}
