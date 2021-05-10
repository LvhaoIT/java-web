package com.controller.Quest;

import com.Dao.QusetDao;
import com.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/10
 * Time: 16:52
 */
public class QuestUpdataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.valueOf(request.getParameter("questionId"));
        Question que = new QusetDao().findOne(questionId);//接收dao值
        request.setAttribute("Que", que);
        //请求转发
        request.getRequestDispatcher("/quest/QusetUpdata.jsp").forward(request, response);
    }
}
