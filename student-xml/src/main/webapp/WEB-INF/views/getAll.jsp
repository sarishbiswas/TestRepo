<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inside getAll</h1>
	<form action="getAll" method="post">
		<table border="2">
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${students}" var="st">
					<tr>
					<td>${st.id}</td>
					<td>${st.name}</td>
					</tr>
			</c:forEach>
	
			<tr>
				<td><input type="submit" name="submit" value="Add"></td>
				<td><input type="reset" value="reset"><a
					href="../../student-xml"><input type="button" value="Home"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>