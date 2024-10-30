<%@page import="com.klef.jfsd.springboot.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
 Customer c=(Customer)   session.getAttribute("customer");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
<%@include file="customernavbar.jsp" %><br/>
Welcome <%=c.getName() %>
</body>
</html>