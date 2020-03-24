<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inside Insert</h1>

	<form action="update" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Update"></td>
				<td><input type="reset" value="reset"><a href="../../student-web-app"><input type="button" value="Home"></a></td>
			</tr>
		</table>
		<h1>message: Update ${msg}</h1>
	</form>
</body>
</html>