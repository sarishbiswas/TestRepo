<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="delete" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Delete"></td>
				<td><input type="reset" value="reset"><a href="../../student-web-app"><input type="button" value="Home"></a></td>
			</tr>
		</table>
		<h1>message: Delete ${msg}</h1>
	</form>
</body>
</html>