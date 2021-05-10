<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.Stu" %>
<%-- Created by IntelliJ IDEA. User: asus Name: 吕昊 Number: 20180508145 Date: 2021/5/9 Time: 15:12 To change this
  template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int age = 19;
    if (age < 18) {


%>
<font style="color:red;font-size:40px">Hello 小朋友</font>
<%
} else

%><font style="color:red;font-size:40px">Hello 成年人</font>

<%

    List<Stu> list = new ArrayList();
    Stu s1 = new Stu(1, "mike");
    Stu s2 = new Stu(2, "hsy");
    Stu s3 = new Stu(3, "lvhaobaodahuasiye");
    list.add(s1);
    list.add(s2);
    list.add(s3);
%>
<table>
    <tr>
        <td>学生学号</td>
        <td>学生姓名</td>
    </tr>
    <%
        for (Stu s : list) {
    %>
    <tr>
        <td><%=s.getId()
        %>
        </td>
        <td><%=s.getName()
        %>
        </td>
    </tr>
    <%
        }
    %>


</table>