package com.controller.Quest;

import com.Dao.QusetDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/11
 * Time: 17:00
 */
public class QuestExamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.初始化需要的属性
        List exam = new QusetDao().examRand();
        //放入数据
        HttpSession session = request.getSession(false);
        session.setAttribute("Examlist", exam);
        //请求转发
        request.getRequestDispatcher("/quest/exam.jsp").forward(request, response);
    }
}
