<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/9
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    jsp文件内置对象，Session
                  类型：HttpSession
                  作用：JSP文件在运行时，可以用session指向当前用户私人储物柜，
                  添加共享数据，或者读取共享数据

--%>

<%
    //这条语句执行前，做了HttpSession session = request。getSession（）
    session.setAttribute("key1", 200);//存放值
%>