<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/9
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //在jsp文件中，只有书写在执行标记中的内容才会被当场java
    //1.可以声明java变量
    //2.声明运行表达式：数学表达式，关系表达式，运算表达式
    //3.声明控制语句
    int num1 = 30;
    int num2 = 40;
%>
变量num1的值为:<%=num1%><br>
变量num1与num2的值为:<%=num1 + num2%>