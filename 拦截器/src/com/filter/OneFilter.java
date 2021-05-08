package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/7
 * Time: 20:12
 */
public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain
            filterChain) throws IOException, ServletException {

        //1.通过拦截请求对象得到请求包参数信息，从而得到来访用户的真实年龄
        String age = servletRequest.getParameter("age");
        //2.根据年龄，帮助http服务器判断本次请求合法性
        if ((Integer.valueOf(age)) < 70) {
            filterChain.doFilter(servletRequest, servletResponse);//检测合法，交还请求对象与响应对象 放行
        } else {
            //过滤器代替Http服务器拒绝本次请求
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.println("<font style='color:red; font-size:40px'>资产不合适，不能看！</font>");
        }
    }
}
