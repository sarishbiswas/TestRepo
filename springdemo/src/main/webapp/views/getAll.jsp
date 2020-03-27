<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
	background-color: #F7C93B; /* Yellow */
	border: none;
	color: white;
	padding: 10px 24px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 2px 1px;
	cursor: pointer;
}

.button1 {
	color: black;
}

.button2 {
	background-color: #008CBA;
} /* Blue */
.button3 {
	background-color: #f44336;
} /* Red */
.button4 {
	background-color: #e7e7e7;
	color: black;
} /* Gray */
.button5 {
	background-color: #555555;
} /* Black */
.button6 {
	background-color: #FF00E4;
} /* Black */
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>Welcome to My Page</h1>
	<h2>Here is all the records after ${res}</h2>
	<table border="2 px solid black" align="center" bgcolor="#64FC59"
		style="color: red">
		<tr>
			<th><font color="blue">ID</font></th>
			<th><font color="blue">Name</font></th>
			<th><font color="blue">Address</font></th>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="insert">
					<button class="button button1">Insert</button>
			</a> <a href="update">
					<button class="button button2">Update</button>
			</a></td>
			<td><a href="delete"><button class="button button3">Delete</button></a>
				<a href="/"><button class="button button4">ShowAll</button></a></td>
			<td><a href="getByName"><button class="button button5">Show
						By Name</button></a> <a href="countStudent"><button class="button button6">Total
						Count</button></a></td>
		</tr>
	</table>

</body>
</html>