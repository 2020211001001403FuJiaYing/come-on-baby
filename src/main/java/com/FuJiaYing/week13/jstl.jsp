<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/11/2022
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 1 - wekk 12</title>
</head>
<body>
<!-- first we need to add lib file-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>use C:forEach - fixed Number of times - tpye 1</h2>
<ul>
    <c:forEach var="i" begin="1" end="10"><!--no step == step=1-->
        <li>${i}</li>
    </c:forEach>

</ul>
<h2>use C:forEach - fixed Number of times with step - type 1</h2>
<ul>
    <c:forEach var="i" begin="1" end="10" step="2">
        <li>${i}</li>
    </c:forEach>

</ul>
<h2>Use C:forEach to get item from array </h2>
<%
String [] words={"foo","biz","pom"};
//must be attribute in any one scope
    request.setAttribute("words",words);

%>
<ul>
    <c:forEach var="w" items="${words}"><!-- findAttribute("words")-->
        <li>${w}</li>
    </c:forEach>
</ul>
</body>
</html>
