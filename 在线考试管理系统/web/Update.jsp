<%@ page import="com.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/10
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users user = (Users) session.getAttribute("upUser");

%>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form action="/demo1/user/update2" method="get">
    <table border="2">
        <tr>
            <td>用户ID：</td>
            <td>
                <input type="text" name="userId" value="<%=user.getUserId()%>" readonly="readonly"/>
            </td>
        </tr>
        <tr>
            <td>
                用户姓名：
            </td>
            <td>
                <input type="text" name="userName" value="<%=user.getUserName()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                密码：
            </td>
            <td>
                <input type="text" name="password" value="<%=user.getPassword()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                性别：
            </td>
            <td>
                <input type="radio" name="sex" value="男"/> 男
                <input type="radio" name="sex" value="女"/> 女
            </td>
        </tr>
        <tr>
            <td>
                邮箱地址：
            </td>
            <td>
                <input type="text" name="email" value="<%=user.getEmail()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改"/>
            </td>
            <td>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>

