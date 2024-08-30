<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
String msg=(String)request.getAttribute("msg");
out.println("page belongs to:"+cb.getfName()+"<br>");
out.println(msg);
%>
<a href="view1">ViewAllBookDetails</a>
</body>
</html>