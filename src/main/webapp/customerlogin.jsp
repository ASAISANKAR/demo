<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
</head>
<body>
<%@include file="mainnavbar.jsp" %>
<h4 align="center" style="color:red">
<c:out value="${message}"></c:out><br/>
</h4>
<h3 align="center">Customer Login Form</h3>

<div class="container">
<form method="post" action="checkcustomerlogin">
<label>Enter Email</label>
<input type="text" name="cemail" required />
<br/>
<label>Enter Password</label>
<input type="text" name="cpwd" required />
<br/>
<input type="submit" value="Login" class="btn btn-success" />
<input type="reset" value="Clear" class="btn btn-danger" />


</form>
</div>


</body>
</html>