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
                    <input type="text" name="questionId" value="${requestScope.Que.queestionID}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>
                    试题内容：
                </td>
                <td>
                    <input type="text" name="title" value="${requestScope.Que.title}">
                </td>
            </tr>
            <tr>
                <td>
                    答案A:
                </td>
                <td>
                    <input type="text" name="optionA" value="${Que.optionA}">
                </td>
            </tr>
            <tr>
                <td>
                    答案B:
                </td>
                <td>
                    <input type="text" name="optionB" value="${requestScope.Que.optionB}">
                </td>
            </tr>
            <tr>
                <td>
                    答案C:
                </td>
                <td>
                    <input type="text" name="optionC" value="${requestScope.Que.optionC}">
                </td>
            </tr>
            <tr>
                <td>
                    答案D:
                </td>
                <td>
                    <input type="text" name="optionD" value="${requestScope.Que.optionD}">
                </td>
            </tr>
            <tr>
                <td>
                    正确答案:
                </td>
                <td>
                    A<input type="radio" name="answer" value="A"  ${"A"== Que.answer?"checked":""}/>
                    B<input type="radio" name="answer" value="B"  ${"B"== Que.answer?"checked":""}/>
                    C<input type="radio" name="answer" value="C"  ${"C"== Que.answer?"checked":""}/>
                    D<input type="radio" name="answer" value="D"  ${"D"== Que.answer?"checked":""}/>
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
