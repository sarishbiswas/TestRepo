<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inside Delete</h1>
	<form action="delete" method="post">
		Id:<input type="text" name="id"><br /> <input type="submit"
			name="submit" value="submit"><br>
			<h1>Delete value: ${msg}</h1>
	</form>
</body>
</html>