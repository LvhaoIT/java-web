package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/7
 * Time: 22:59
 */
public class OneFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //ServletRequest下没有getSession方法，这个方法在它的子接口中，（向下转型）
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //调用请求对象读取请求包中URI，了解用户访问的资源文件是谁
        String URI = request.getRequestURI();//[/网站名称/资源名称]

        //如果本次请求文件与用户登录相关，或者是默认请求 则无条件放行
        if (URI.indexOf("login") != -1 || "/demo1/".equals(URI)) {
            //indexof，查找字符串在其中出现的第一位置，未找到则返回-1
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getSession(false) == null) {
            //用户不合法，直接送走(重定向)
            request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
            return;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }
}
