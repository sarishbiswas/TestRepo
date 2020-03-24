<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Student Details</h1>
	<table border="2" align="center">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${list}" var="st">
			<tr>
				<td>${st.id}</td>
				<td>${st.firstName}</td>
				<td>${st.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../../student-web-app"><input type="button" value="Home"></a>
</body>
</html>