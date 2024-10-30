<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer by Admin</title>
</head>
<body>
<%@include file="adminnavbar.jsp" %>

<h3 align="center">Customer Registration by Admin</h3>

<div class="container">
<form method="post" action="insertcustomerbyadmin">
<label>Enter name</label>
<input type="text" name="cname" required />
<br/>
<label>select Gender</label>
<input type="radio" name="cgender" value="Male" required />Male
<input type="radio" name="cgender" value="Female" required />Female
<input type="radio" name="cgender" value="Others" required />Others
<br/>
<label>Select Date of Birth</label>
<input type="date" name="cdob" required />
<br/>
<label>Enter Email ID</label>
<input type="text" name="cemail" required />
<br/>
<label>Enter Password</label>
<input type="text" name="cpassword" required />
<br/>
<label>Enter Location</label>
<input type="text" name="clocation" required />
<br/>
<label>Enter Contact</label>
<input type="text" name="ccontact" required />
<br/>
<input type="submit" value="Register" class="btn btn-success" />
<input type="reset" value="Clear" class="btn btn-danger" />


</form>
</div>


</body>
</html>