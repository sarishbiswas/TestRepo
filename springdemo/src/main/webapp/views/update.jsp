<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h1>Welcome to Update Page</h1>
	<h2>Enter the values to update</h2>
	<form:form action="update" method="post" modelAttribute="student">
		<table bgcolor="cyan" align="center">

			<tr>
				<th><form:label path="id">ID:</form:label></th>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<th><form:label path="name">NAME:</form:label></th>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th><form:label path="address">ADDRESS:</form:label></th>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><input type="reset" name="reset" value="Reset"
					class="button button3" /></td>
				<td><input type="submit" name="submit" value="Update"
					onclick="alert('SUCCESSFULL')" class="button button5" /> <a
					href="/"><input type="button" name="home" value="ShowAll"
						class="button button4" /></a></td>
			</tr>
		</table>


	</form:form>
</body>
</html>