package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/5
 * Time: 16:59
 */
public class oneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象，读取请求头参数
        String goodsName;
        request.setCharacterEncoding("utf-8");
        goodsName = request.getParameter("goodsName");
        System.out.println("进入了断点1！！");
        //2.调用请求对象，向tomcat索要私人储物柜
        HttpSession session = request.getSession();
        //3.将用户选购商品添加到当前私人储物柜
        Integer goodsNum = (Integer) session.getAttribute(goodsName);//取商品数量
        //判断商品是否是第一次放入
        if (goodsNum == null) {
            session.setAttribute(goodsName, 1);
        } else {
            //存在过，则加一
            session.setAttribute(goodsName, goodsNum + 1);
        }
    }
}
