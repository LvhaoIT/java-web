package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/11
 * Time: 10:38
 */
public class oneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext(); //全局作用域对象
        HttpSession session = request.getSession();//会话作用域对象

        application.setAttribute("application", "全局作用域对象");
        session.setAttribute("session", "会话作用域对象");
        request.setAttribute("request", "请求作用域对象");//请求作用域对象

        //请求转发
        request.getRequestDispatcher("/index_1.jsp").forward(request, response);


    }
}
