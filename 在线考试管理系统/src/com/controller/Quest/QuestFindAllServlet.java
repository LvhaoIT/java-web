package com.controller.Quest;

import com.Dao.QusetDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/10
 * Time: 14:13
 */
public class QuestFindAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List questlist = new ArrayList();
        new QusetDao().findAll(questlist);
        request.setAttribute("questlist", questlist);
        request.getRequestDispatcher("/quest/findAll.jsp").forward(request, response);
    }
}
