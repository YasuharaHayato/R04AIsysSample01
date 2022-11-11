<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String string = (String)request.getAttribute("string");
	String message = (String)(request.getAttribute("message"));
%>

<body>
<H1>Sentiment</H1>
<H3>文章：<%= string %></H3>
<H3>結果：<%= message %></H3>

</body>
</html>