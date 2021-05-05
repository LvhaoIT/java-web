package com.Cookie.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/5
 * Time: 14:14
 */
public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double jiaozi_money = 30;
        double gaifan_money = 21;
        double miantiao_money = 20;
        double money = 0;
        double xiaofei = 0;
        String food, userName = null;

        //修改响应体字符集
        response.setContentType("text/html;charset=utf-8");
        //获取输出流对象
        PrintWriter out = response.getWriter();
        //定义一个新的Cookie，用新处理的值覆盖以前的cookie
        Cookie newCard = null;

        //1.读取请求头参数信息，得到用户点餐的食物类型
        food = request.getParameter("food");
        //2。读取请求中的Cookie
        Cookie[] cookieArray = request.getCookies();//取出所有cookie
        //3.刷卡消费
        for (Cookie card : cookieArray) {
            //取出数据并且对应处理
            String key = card.getName();//获取key
            String value = card.getValue();//获取value
            //判断取出的是否为用户名
            if (key.equals("userName")) {
                //是用户名
                userName = value;//找到对应用户名
            } else if (key.equals("money")) {//取出的是money
                money = Double.valueOf(value); //将钱存起来
                //开始消费 food里存的是食物名称
                if (food.equals("饺子")) {
                    //点的是饺子，但是需要判断钱够不够
                    if (money < jiaozi_money) {
                        out.print("用户" + userName + "余额不足,请充值！");
                    } else {
                        //钱够，可以消费
                        newCard = new Cookie("money", (money - jiaozi_money) + "");
                        xiaofei = jiaozi_money;
                    }
                } else if (food.equals("面条")) {
                    //点的是饺子，但是需要判断钱够不够
                    if (money < jiaozi_money) {
                        out.print("用户" + userName + "余额不足,请充值！");
                    } else {
                        //钱够，可以消费
                        newCard = new Cookie("money", (money - miantiao_money) + "");
                        xiaofei = miantiao_money;
                    }
                } else if (food.equals("盖饭")) {
                    //点的是饺子，但是需要判断钱够不够
                    if (money < jiaozi_money) {
                        out.print("用户" + userName + "余额不足,请充值！");
                    } else {
                        //钱够，可以消费
                        newCard = new Cookie("money", (money - gaifan_money) + "");
                        xiaofei = gaifan_money;
                    }
                }
            }
        }
        //4.返还用户会员卡
        response.addCookie(newCard);
        //5.消费记录写入到响应对象中
        out.println("用户" + userName + "本次消费：" + xiaofei + "  卡内余额剩余：" + (money - xiaofei));
    }
}