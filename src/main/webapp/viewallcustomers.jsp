<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home</title>
</head>
<body>
<%@include file="adminnavbar.jsp" %><br/><br/>
<h4 align="center" style="color:green">
<c:out value="${message}"></c:out>
</h4>

Customers Count =<c:out value="${count}"></c:out>
<h2 align="center">View All Customers</h2>
<table align="center" border=2>
<tr>
<th>ID</th>
<th>NAME</th>
<th>GENDER</th>
<th>DATE OF BIRTH</th>
<th>EMAIL</th>
<th>LOCATION</th>
<th>CONTACT NO</th>
</tr>
<c:forEach items="${customerlist}" var="customer">
<tr>
<td><c:out value="${customer.id}"></c:out> </td>
<td><c:out value="${customer.name}"></c:out> </td>
<td><c:out value="${customer.gender}"></c:out> </td>
<td><c:out value="${customer.dateofbirth}"></c:out> </td>
<td><c:out value="${customer.email}"></c:out> </td>
<td><c:out value="${customer.location}"></c:out> </td>
<td><c:out value="${customer.contact}"></c:out> </td>
</tr>
</c:forEach>
</table>

</body>
</html>