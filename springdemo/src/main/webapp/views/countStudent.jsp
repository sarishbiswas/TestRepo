<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


</head>
<body align="center">
	<h1>The number of students is ${count}</h1>
	<br>
	<br>
	<table border="1" bgcolor="cyan" style="color: #FF0000" align="center">
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