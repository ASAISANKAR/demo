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
<h3>My Profile</h3>
ID: <%=c.getId() %><br/>
NAME: <%=c.getName() %><br/>
GENDER: <%=c.getGender() %><br/>
DOB: <%=c.getDateofbirth() %><br/>
EMAIL: <%=c.getEmail() %><br/>
LOCATION: <%=c.getLocation() %><br/>
CONTACT: <%=c.getContact() %><br/>
</body>
</html>