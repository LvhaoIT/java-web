<%@ page import="com.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/10
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Question que = (Question) request.getAttribute("Que");//获取数据
%>
<html>
<head>
    <title>修改试题信息</title>
</head>
<body>
<center>
    <form action="/demo1/quest/updata2" method="get">
        <table border="2">
            <tr>
                <td>试题ID：</td>
                <td>
                    <input type="text" name="questionId" value="<%=que.getQueestionID()%>" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>
                    试题内容：
                </td>
                <td>
                    <input type="text" name="title" value="<%=que.getTitle()%>">
                </td>
            </tr>
            <tr>
                <td>
                    答案A:
                </td>
                <td>
                    <input type="text" name="optionA" value="<%=que.getOptionA()%>">
                </td>
            </tr>
            <tr>
                <td>
                    答案B:
                </td>
                <td>
                    <input type="text" name="optionB" value="<%=que.getOptionB()%>">
                </td>
            </tr>
            <tr>
                <td>
                    答案C:
                </td>
                <td>
                    <input type="text" name="optionC" value="<%=que.getOptionC()%>">
                </td>
            </tr>
            <tr>
                <td>
                    答案D:
                </td>
                <td>
                    <input type="text" name="optionD" value="<%=que.getOptionD()%>">
                </td>
            </tr>
            <tr>
                <td>
                    正确答案:
                </td>
                <td>
                    A<input type="radio" name="answer" value="A" <%="A".equals(que.getAnswer()) ? "checked" : "" %>/>
                    B<input type="radio" name="answer" value="B" <%="B".equals(que.getAnswer()) ? "checked" : "" %>/>
                    C<input type="radio" name="answer" value="C" <%="C".equals(que.getAnswer()) ? "checked" : "" %>/>
                    D<input type="radio" name="answer" value="D" <%="D".equals(que.getAnswer()) ? "checked" : "" %>/>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="更新试题"/>
                </td>
                <td>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
