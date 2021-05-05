package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/5
 * Time: 17:11
 */
public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象，向tomcat索要当前用户在服务端的私人储物柜
        HttpSession session = request.getSession();
        System.out.println("进入了断点2！！");
        //2.将session中所有的key取出来，存放在一个枚举对象中
        Enumeration goodNames = session.getAttributeNames();
        //hasMoreElements()当且仅当此枚举对象至少还包含一个可提供的元素时，才返回 true；否则返回 false。
        while (goodNames.hasMoreElements()) {
            //E nextElement()
            //如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
            String goodName = (String) goodNames.nextElement();//取出下一个商品名
            int goodsNum = (int) session.getAttribute(goodName);//取出对应商品名称的件数
            System.out.println("商品名称：" + goodName + "商品数量：" + goodsNum);

        }
    }
}
