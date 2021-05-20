package com.controller;

import com.entity.Dept;
import net.sf.json.JSONArray;

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
 * Date: 2021/5/21
 * Time: 0:21
 */
public class threeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得一个集合存放部门对象
        List DeptList = new ArrayList();
        DeptList.add(new Dept(10,"徐州工程学院","徐州"));
        DeptList.add(new Dept(20,"淮阴工学院","淮安"));
        DeptList.add(new Dept(30,"三江学院","南京"));

        JSONArray jsonArray = JSONArray.fromObject(DeptList);//利用json工具类，转换json对象
        //调用请求对象，请求作用域对象
        request.setAttribute("key2",jsonArray);
        //请求转发
        request.getRequestDispatcher("/index_2.jsp").forward(request,response);
    }
}
