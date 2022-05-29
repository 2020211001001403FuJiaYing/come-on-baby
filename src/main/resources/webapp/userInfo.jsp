<%--
  Created by IntelliJ IDEA.
  User: 8618296836794
  Date: 2022/3/31
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="view/header.jsp"%>
<h1> User Info</h1>
<table>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("id")%></td>
    </tr><tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr><tr>
    <td>password:</td><td><%=request.getAttribute("password")%></td>
</tr><tr>
    <td>email:</td><td><%=request.getAttribute("email")%></td>
</tr><tr>
    <td>sex:</td><td><%=request.getAttribute("gender")%></td>
</tr><tr>
    <td>data:</td><td><%=request.getAttribute("birthDate")%></td>
</tr>

</table>
<%@include file="view/footer.jsp"%>
