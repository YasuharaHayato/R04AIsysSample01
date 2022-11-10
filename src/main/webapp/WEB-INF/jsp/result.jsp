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
	double message1 = (double)request.getAttribute("message1");
	double message2 = (double)(request.getAttribute("message2"));
	double message3 = (double)(request.getAttribute("message3"));
%>

<body>
<H1>Sentiment</H1>
<H3>文章：<%= string %></H3>
<H3>結果：<br></H3>
<%= "positive:"+ message1 %>
<%= "neutral:"+ message2 %>
<%= "negative:"+ message3 %>
</body>
</html>