package com.demo01.controller.Response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 子类----》父类----》A接口 此时 子类也是A接口实现类
 * <p>
 * 袁绍 PK 曹操 曹操宦官之后
 * <p>
 * 曹操----爹【正常人】---->宦官【接口】
 * <p>
 * 抽象类作用：降低接口实现类对接口实现过程难度 将接口中不需要使用抽象方法教给抽象类进行完成 这样接口实现类只需要对接口需要方法进行重写 servlet接口: init getServletConfig getServletInfo
 * destory-----------四个方法对于Servlet接口实现类没用
 * <p>
 * service()----有用
 * <p>
 * Tomcat根据Servlet规范调用Servlet接口实现类规则: 1.Tomcat有权创建Servlet接口实现类实例对象 Servlet oneServlet = new OneServlet();
 * 2.Tomcat根据实例对象调用service方法处理当前请求 oneServlet.service(),此时service方法中 this=====oneServlet extends extends implements
 * oneServlet---------->(abstract)HttpServlet----->(abstract)GenericServlet----------> servlet接口 init destory
 * getServletInfo getServletConfig
 * <p>
 * 通过父类决定在何种情况下调用子类中方法-------【设计模式】---模板设计模式
 * <p>
 * HttpServlet: service（）{
 * <p>
 * if(请求方式 == GET){ this.doGet }else if(请求方式 == POST){ this.doPost }
 * <p>
 * } doGet doPost
 * <p>
 * OneServlet: doGet doPost
 * <p>
 * Servlet oneServlet = new OneServlet(); oneServlet.service()
 * <p>
 * 复习: 重写规则 * 抽象类作用 * 子类实现接口规则 * this指向 * 继承规则
 */
public class OneServlet extends HttpServlet {
    public OneServlet() {
        System.out.println("OneServlet已经被创建！");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送GET请求方式处理");
        String result = "servlet One ，Hello Word！";
        PrintWriter out = response.getWriter();
        out.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("OneServlet类针对浏览器发送POST请求方式处理");
    }

}
