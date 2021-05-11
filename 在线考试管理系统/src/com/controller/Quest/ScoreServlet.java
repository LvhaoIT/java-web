package com.controller.Quest;

import com.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/11
 * Time: 20:49
 */
public class ScoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取session中的题目信息
        List<Question> examlist = (List) request.getSession().getAttribute("Examlist");
        //2.从请求数据包读取用户对于四道题目的答案
        int score = 0;
        for (Question q : examlist) {
            String answerStr = "answer_" + q.getQueestionID();//key
            String examDA = request.getParameter(answerStr);//value
            request.setAttribute(answerStr, examDA);
            if (q.getAnswer().equals(examDA)) {
                //相同则正确 ，否则则错误
                score += 25;
            }

        }
        //3、写入分数到共享数据中
        request.setAttribute("score", score);
        //4、请求转发过去
        request.getRequestDispatcher("/quest/score.jsp").forward(request, response);
    }
}
