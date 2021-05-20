package com.controller;

import com.entity.Dept;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 23:31
 */
public class twoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dept dept = new Dept(1,"徐州工程学院","徐州"); //这种传值是错误的，高级类型传的是内存地址

        JSONObject jsonObject = JSONObject.fromObject(dept);//利用json工具类来转换成json字符串
        request.setAttribute("key1",jsonObject.toString());
        //转到jsp运行
        request.getRequestDispatcher("/index_1.jsp").forward(request,response);

    }
}
