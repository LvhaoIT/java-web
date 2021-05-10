<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/10
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String info = (String) request.getAttribute("info");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font style="color: red;font-size: 40px"><%=info + "!"%>
</font>

</body>
</html>
