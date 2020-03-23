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
	<form action="insert" method="post">
		Id:<input type="text" name="id"><br /> Name:<input
			type="text" name="name"><br> <input type="submit"
			name="submit" value="submit"><br>
			<h1>Insert value : ${msg}</h1>
	</form>
</body>
</html>