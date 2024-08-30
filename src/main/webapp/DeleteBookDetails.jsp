<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
BookBean bb=(BookBean)request.getAttribute("bbean");
out.println("page belongs to:"+ab.getfName()+"<br>");
%>
<form action="delete" method="post">
<input type="text" name="bcode" value=<%=bb.getCode() %>>
<a href="Book.html">AddBookDetails</a>
<a href="view1">ViewAllBookDetails</a>
<a href="logout">Logout</a>
<input type="submit" value="DeleteBookDetails">
</form>

</body>
</html>