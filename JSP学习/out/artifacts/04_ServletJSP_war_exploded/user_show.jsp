<%@ page import="java.util.List" %>
<%@ page import="com.entity.Stu" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/9
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //从请求作用域对象中得到OneServlet添加进去的集合
    List<Stu> stuList = (List) request.getAttribute("key");

%>
<!--将处理结果写入到响应体-->
<table border="2" align="center">
    <tr>
        <td>学生学号</td>
        <td>学生姓名</td>
    </tr>
    <%
        for (Stu s : stuList) {
    %>
    <tr>
        <td><%=s.getId()%>
        </td>
        <td><%=s.getName()%>
        </td>
    </tr>
    <%
        }
    %>
</table>