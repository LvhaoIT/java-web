<%@ page import="java.util.List" %>
<%@ page import="com.entity.Question" %><%-- Created by IntelliJ IDEA. User: asus Name: 吕昊 Number: 20180508145 Date: 2021/5/11 Time: 19:59 To change this
  template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>考试页面</title>
</head>

<body>
<center>
    <form action="/demo1/quest/exam" method="GET">
        <table border="2" align="center">
            <tr>
                <td>试题编号</td>
                <td>题目信息</td>
                <td>A</td>
                <td>B</td>
                <td>C</td>
                <td>D</td>
                <td>请选择你的答案</td>
            </tr>
            <%
                List<Question> list = (List) session.getAttribute("Examlist");
                for (Question q : list) {

            %>
            <tr>
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
                    <input type="radio" name="answer_<%=q.getQueestionID()%>" value="A"/>A
                    <input type="radio" name="answer_<%=q.getQueestionID()%>" value="B"/>B
                    <input type="radio" name="answer_<%=q.getQueestionID()%>" value="C"/>C
                    <input type="radio" name="answer_<%=q.getQueestionID()%>" value="D"/>D
                </td>
            </tr>

            <%
                }
            %>
            <tr align="center">
                <td colspan="3">
                    <input type="submit" value="提交试卷">
                </td>
                <td colspan="4">
                    <input type="reset" value="重做试卷">
                </td>
            </tr>
        </table>
    </form>

</center>

</body>

</html>