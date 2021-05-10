package com.controller.Quest;

import com.Dao.QusetDao;
import com.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/10
 * Time: 18:57
 */
public class QuestUpdataServlet_2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Question que = new Question(Integer.valueOf(request.getParameter("questionId")),
                request.getParameter("title"),
                request.getParameter("optionA"),
                request.getParameter("optionB"),
                request.getParameter("optionC"),
                request.getParameter("optionD"),
                request.getParameter("answer"));
        int result = new QusetDao().updata(que);
        if (result == 1) {
            out.println("<font style='color:red; font-size:40px'>更新成功！</font>");
        } else {
            out.println("<font style='color:red; font-size:40px'>更新失败！</font>");
        }
    }
}
