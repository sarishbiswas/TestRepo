<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<div class="container">
<h1 class="text-center">Please Login to Move to the next page</h1>
<form:form action="validate" method="post" modelAttribute="user">
<center>
		<table>
			<tr>
				<th>Username : </th>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="errors text-danger" /></td>
			</tr>
			<tr>
				<th>Password : </th>
				<td><form:input path="password" type="password" /></td>
				<td><form:errors path="password" cssClass="errors text-danger" /></td>
			</tr>
			<tr><td></td><td><input type="submit" name="submit" value="Login" class="btn btn-primary"></td></tr>
		</table>

</center>
	</form:form>
</div>
</body>
</html>