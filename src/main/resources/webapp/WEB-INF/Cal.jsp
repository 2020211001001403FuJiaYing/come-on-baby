
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2022/5/29
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//.println(basePath);
%>
<html>
<head>
	<title>cal</title>
	<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<style>
	input {
		outline: none;
		border: 0;
		box-shadow: inset 1px 1px 1px 2px lightgrey;
		width: 70px;
		height: 25px;
	}
	div {
		margin-bottom: 10px;
	}
	label {
		display: inline-block;
		width: 120px;
	}
	button {
		margin-right: 10px;
	}
</style>
<body>
<form method="post" action="<%=basePath%>calServlet" id="myForm">
	<div>
		<label for="first">First Val:</label><input id="first" name="first" value="${empty cookie.cFirstValue?"":cookie.cFirstValue.value}">
		<label for="name" style="margin-left: 40px">Enter a name:</label><input id="name" name="name" value="${empty cookie.cNameValue?"":cookie.cNameValue.value}">
	</div>
	<div>
		<label for="second">Second Val:</label><input id="second" name="second" value="${empty cookie.cSecondValue?"":cookie.cSecondValue.value}">
		<label for="len" style="margin-left: 40px">Length:</label><input id="len" name="len" readonly value="${empty cookie.cLenValue?"":cookie.cLenValue.value}">
	</div>
	<div><label for="result">Result:</label><input id="result" name="result" readonly value="${empty cookie.cResult?"":cookie.cResult.value}"></div>
	<div>
		<button name="action" type="hidden" value="add">Add</button>
		<button name="action" type="hidden" value="subtract">Subtract</button>
		<button name="action" type="hidden" value="multiply">Multiply</button>
		<button name="action" type="hidden" value="divide">Divide</button>
		<button name="action" type="hidden" value="compute">Compute Length</button>
		<button name="action" type="hidden" value="re">Reset</button>
	</div>
</form>
</body>
<script>
	$(document).ready(function() {
				$('button').click(function () {
					var first = $("#first").val()
					var name = $("#name").val()
					var second = $("#second").val()
					var id = $(this).attr('value')
					if (id == "add" || id == "subtract" || id == "multiply") {
						if (isNaN(first)) {
							alert("First Value is not a Number!")
							return false
						} else if (isNaN(second)) {
							alert("Second Value is not a Number!")
							return  false
						} else if (first % 1 !== 0 || second % 1 !== 0) {
							alert("Please enter an integer!")
							return false
						}
					} else if (id == "divide") {
						if (isNaN(first)) {
							alert("First Value is not a Number!")
							return false
						} else if (isNaN(second)) {
							alert("Second Value is not a Number!")
							return  false
						} else if (first % 1 !== 0 || second % 1 !== 0) {
							alert("Please enter an integer!")
							return false
						} else if (second == 0) {
							alert("Second Value is not Valid!")
						}
					} else if (id == "compute") {
						if (!isNaN(name)) {
							alert("Name is not Valid!")
							return false
						}
					} else if (id == "re") {
						document.getElementById("myForm").reset()
						return  false
					}
					return true
				})
			}
	)
</script>
</html>