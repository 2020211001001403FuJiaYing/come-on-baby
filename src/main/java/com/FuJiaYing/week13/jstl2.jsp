<%@ page import="com.dabing.week11.Person" %>
<%@ page import="com.dabing.week11.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2022
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo - 1 - week 13</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//set
    //session.setAttribute("username","ADMIN");

    //week 13 - no java code - JSTL to do same
%>
<c:set var="username" value="ADMIN" scope="session"/>
<h1>Welcome,  <c:out value="${username}" default="<font color=red>Guest</font>" escapeXml="false"/>
<!-- what this line will print? if username = null ==> print nothing-->
</h1>
<hr>
<h2>Use c:set - use 1- set attribute in any one scope</h2>
<%
//java code
    ///pageContext.setAttribute("attName"," in page");
   // request.setAttribute("attName"," in request");
  //  session.setAttribute("attName"," in session");
 //   application.setAttribute("attName"," in application");

    //week 13 - no java code - use JSTL
%>
<c:set var="attName" value="in page" scope="page"/>
<c:set var="attName" value="in request" scope="request"/>
<c:set var="attName" value="in session" scope="session"/>
<c:set var="attName" value="in application" scope="application"/>

Get Att value :<c:out value="${attName}"/><!-- Guess ?which one ?A=page, b=request, C= session d= application-->
<h2>Use c:set - use 2- set bean property </h2>
<%
Person p=new Person();
///p.setName("TOM");//chnage this line c-set
Dog d=new Dog();
//d.setName("TOMMY");//chnage

//p.setDog(d);//change
request.setAttribute("p",p);
request.setAttribute("d",d);

///week 13- no java code - JSTL
%>
<c:set target="${p}" property="name" value="TOM"/>
<c:set target="${d}" property="name" value="TOMMY"/>
<c:set target="${p}" property="dog" value="${d}"/>

${p.name}s' Dog Name --> ${p.dog.name}
<hr>
<h2>Use c:remove- remove att from any one scope(no scope ==all scope)</h2>
<h3>Get Before Remove</h3>
Att value :<c:out value="${pageScope.attName}"/><br>
Att value :<c:out value="${requestScope.attName}"/><br>
Att value :<c:out value="${sessionScope.attName}"/><br>
Att value :<c:out value="${applicationScope.attName}"/><br>
<c:remove var="attName" scope="session"/>
<h3>Get After Remove</h3>
Att value :<c:out value="${pageScope.attName}"/><br>
Att value :<c:out value="${requestScope.attName}"/><br>
Att value :<c:out value="${sessionScope.attName}"/><br>
Att value :<c:out value="${applicationScope.attName}"/><br>
<hr>
<h2>Use c:catch</h2>
<c:catch var="msg">
<%
//try {
    int i = 10 / 0;//problem
//}catch(Exception e)
//{
  //  e.getMessage();
//}
//week 13 - No java code - use JSTL
%>
</c:catch>
Exception : ${msg}
<hr>
<h2>Use c:if</h2>
<ul>
   <c:forEach var="i" begin="1" end="10">
       <li>${i}
       <c:if test="${i>7}">
           (greater than 7)
       </c:if>


       </li>
   </c:forEach>
</ul>
<hr>
<h2>USe c:choose , c:when, c:otherwise</h2>
<ul>
    <c:forEach var="i" begin="1" end="10">
        <li>${i}
            <c:choose>
                <c:when test="${i<4}">
                    (Small)
                </c:when>
                <c:when test="${i<8}">
                    (Medium)
                </c:when>
                <c:otherwise>
                    (Large)
                </c:otherwise>
            </c:choose>


        </li>
    </c:forEach>
</ul>
<hr>
<h2> Use C:import </h2>

<hr>
<h2>Use c:URL</h2>

<a href="home">Go to home( without c:url)</a><br>
<a href='<c:url value="home"/>'>Go to home (using c-url)</a><!-- better - 1. do encoding 2. add parameter 3. do url rewriting-->
<c:url var="myUrl" value="home">
<c:param name="productId" value="2312"/>
<c:param name="username" value="admin"/>
</c:url>
<form action="${myUrl}">

</form>
<br>
<a href="${myUrl}">Go to home (use c- url with c- param)</a>
<hr>
<h2> use c:redirect</h2>
<c:redirect url="${myUrl}"/>
</body>
</html>
