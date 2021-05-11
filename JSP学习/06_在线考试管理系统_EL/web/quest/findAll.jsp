<%@ page import="com.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/10
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Question> list = (List) request.getAttribute("questlist");

%>
<html>

<head>
    <title>所有试题</title>
</head>
<body>
<center>
    <table border="2" align="center">
        <tr align="center">
            <td>
                试题编号
            </td>
            <td>
                题干
            </td>
            <td>
                正确答案
            </td>
            <td>
                选项A
            </td>
            <td>
                选项B
            </td>
            <td>
                选项C
            </td>
            <td>
                选项D
            </td>
            <td colspan="2">
                试题操作
            </td>
        </tr>
        <%
            int i = 0;
            for (Question q : list) {
                if (i++ % 2 == 0) {
        %>
        <tr style="background-color:green ">
                <%
        } else {
        %>
        <tr style="background-color:yellow ">
            <% }
            %>

            <td><%=q.getQueestionID()%>
            </td>
            <td><%=q.getTitle()%>
            </td>
            <td><%=q.getAnswer()%>
            </td>
            <td><%=q.getOptionA()%>
            </td>
            <td><%=q.getOptionB()%>
            </td>
            <td><%=q.getOptionC()%>
            </td>
            <td><%=q.getOptionD()%>
            </td>
            <td><a href=<%="/demo1/quest/delete?questionId=" + q.getQueestionID() + ""%>>删除试卷 </a>
            </td>
            <td><a href=<%="/demo1/quest/updata1?questionId=" + q.getQueestionID() + ""%>>修改试卷</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</center>

</body>
</html>
