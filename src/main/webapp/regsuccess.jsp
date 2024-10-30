<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Message</title>
</head>
<body>
<h4 align="center" style="color:green">
<c:out value="${message}"></c:out>
</h4>
<a href="customerlogin">Login Here</a>
</body>
</html>