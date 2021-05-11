<%@ page import="com.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/11
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试题分析</title>
</head>
<body>
<center>
    <table border="1" align="center">
        <tr align="center">
            <td>试题编号</td>
            <td>题目信息</td>
            <td>选项A</td>
            <td>选项B</td>
            <td>选项C</td>
            <td>选项D</td>
            <td>你的答案</td>
            <td>正确答案</td>
        </tr>
        <%
            List<Question> list = (List) session.getAttribute("Examlist");
            for (Question q : list) {

        %>
        <tr align="center">
            <td><%=q.getQueestionID()%>
            </td>
            <td><%=q.getTitle()%>
            </td>
            <td><%=q.getOptionA()%>
            </td>
            <td><%=q.getOptionB()%>
            </td>
            <td><%=q.getOptionC()%>
            </td>
            <td><%=q.getOptionD()%>
            </td>
            <td>
                <font color=<%=(q.getAnswer().equals(request.getAttribute("answer_" + q.getQueestionID())) ? "blue" : "red")%>>
                    <%=request.getAttribute("answer_" + q.getQueestionID())%>
                </font>

            </td>
            <td><%=q.getAnswer()%>
            </td>
        </tr>

        <%
            }
        %>

        </tr>
    </table>
    <br>

    <font color="red" size="40px">最终成绩：<%=request.getAttribute("score")%>
    </font>


</center>
</body>
</html>
