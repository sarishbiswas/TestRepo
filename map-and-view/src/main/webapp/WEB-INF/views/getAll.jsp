<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inside GetAll</h1>
	<table border="2" height="50%" width="50%">
		<tr>
			<td>ID</td>
			<td>NAME</td>
		</tr>
		<tbody>
			<c:forEach items="${list}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="insert"><input type="button" name="home"
						value="INSERT" /></a>
	<a href="update"><input type="button" name="home"
						value="UPDATE" /></a>
	<a href="delete"><input type="button" name="home"
						value="DELETE" /></a>
</body>
</html>