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
 * Time: 10:25
 */
public class QuestAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        String answer;

        //请求头获取数据
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        Question que = new Question(title, optionA, optionB, optionC, optionD, answer);

        //通过请求转发，把数据传给jsp
        int result = new QusetDao().add(que);
        if (result == 1) {
            request.setAttribute("info", "试题添加成功");

        } else {
            request.setAttribute("info", "试题添加失败");
        }

        request.getRequestDispatcher("/quest/info.jsp").forward(request, response);

    }
}
