package com.controller.Quest;

import com.Dao.QusetDao;

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
 * Time: 15:19
 */
public class QuestDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Integer questionId = Integer.valueOf(request.getParameter("questionId"));
        int result = new QusetDao().delete(questionId);
        if (result == 1) {
            out.println("<p1 style='color: brown; font-size: 30px;'>");
            out.println("编号为：" + questionId + "数据删除成功！");
            out.println("</p1>");
        } else {
            out.println("<p1 style='color: gree; font-size: 30px;'>");
            out.println("编号为：" + questionId + "数据失败！");
        }


    }
}
