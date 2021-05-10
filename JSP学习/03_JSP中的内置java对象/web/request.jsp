<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/9
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    jsp文件内置对象：request
    类型：HttpServletRequest
    作用：在JSP文件运行时读取请求包信息
        与Servlet在请求转发过程中实现数据共享

    利用request来读取请求包中参数
    http://localhost:8080/03_JSPjava_war_exploded/request.jsp?userName=hsy&passWord=huasiye1
--%>
<%
    String userName = request.getParameter("userName");
    String passWord = request.getParameter("passWord");
%>
来访用户的姓名:<%=userName%><br>
来访用户的密码:<%=passWord%>