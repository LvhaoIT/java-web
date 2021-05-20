<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/20
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function fun1(){
            var dept = ${requestScope.key1};
            document.getElementById("deptNo").value=dept.deptNo;
            document.getElementById("deptName").value=dept.deptName;
            document.getElementById("loc").value=dept.loc;
        }



    </script>
</head>
<body onload="fun1()">

<table border="2">
    <tr>
        <td>部门编号</td>
        <td><input type="text" id="deptNo"></td>
    </tr>
    <tr>
        <td>部门名称</td>
        <td><input type="text" id="deptName"></td>
    </tr>
    <tr>
        <td>部门编号</td>
        <td><input type="text" id="loc"></td>
    </tr>
</table>
  
  </body>
</html>
