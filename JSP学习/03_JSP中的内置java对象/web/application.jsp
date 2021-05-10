<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/9
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    jsp文件内置对象，
                  类型：ServletContext application 全局作用域对象
                  作用：同一个网站中的Servlet与JSP，都可以通过当前网站的全局作用域对象实现数据共享
                  JSP文件内置对象：application

--%>
<%
    application.setAttribute("key1", "hello world");
%>