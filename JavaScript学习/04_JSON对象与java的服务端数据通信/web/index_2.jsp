<%--
  Created by IntelliJ IDEA.
  User: asus
  Name: 吕昊
  Number: 20180508145
  Date: 2021/5/21
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function  fun1(){
            var jsonArray = ${requestScope.key2};//获取对象
            //利用for循环输出
            for(var i=0;i<jsonArray.length;i++){
                var jsonObj = jsonArray[i];//获取当前对象
                //在页面中创建新的表行
                var trDom = document.createElement("tr");//<tr></tr>
                var tdDOm_1 = document.createElement("td")//<td>
                var tdDOm_2 = document.createElement("td")//<td>
                var tdDOm_3 = document.createElement("td")//<td>
                tdDOm_1.innerHTML=jsonObj.deptNo;
                tdDOm_2.innerHTML=jsonObj.deptName;
                tdDOm_3.innerHTML=jsonObj.loc; //向td中插值
                trDom.appendChild(tdDOm_1);//插入对应位置 ，插入到tr中
                trDom.appendChild(tdDOm_2);
                trDom.appendChild(tdDOm_3);
                document.getElementById("one").appendChild(trDom);//放入位置
            }
        }
    </script>

</head>
<body onload="fun1()">
<center>
 <table border="2" align="center"  id="one">
     <tr>
         <td>部门编号</td>
         <td>部门名称</td>
         <td>部门地址</td>
     </tr>
 </table>
</center>
  </body>
</html>
