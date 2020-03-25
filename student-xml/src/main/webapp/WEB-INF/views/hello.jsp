<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO ${student}</h1>


<form:form action="hello" method="post" modelAttribute="student">

		<form:label path="id">Id</form:label>
		<form:input path="id" />

		<form:label path="name">Name</form:label>
		<form:input path="name" />

		<input type="submit" name="submit" value="submit" />

</form:form>

</body>
</html>