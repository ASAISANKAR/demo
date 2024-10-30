<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<%@include file="mainnavbar.jsp" %>
<h3 align="center">Admin Login Form</h3>

<div class="container">
<form method="post" action="checkadminlogin">
<label>Enter Username</label>
<input type="text" name="auname" required />
<br/>
<label>Enter Password</label>
<input type="text" name="apwd" required />
<br/>
<input type="submit" value="Login" class="btn btn-success" />
<input type="reset" value="Clear" class="btn btn-danger" />


</form>
</div>


</body>
</html>