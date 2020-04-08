<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.errors {
	color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="edit-menu-item" method="post" modelAttribute="menuItem">
	<form:input type="hidden" path="id" value="${menuItem.id}"/>
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name" value="${menuItem.name}" /></td>
				<td><form:errors path="name" cssClass="errors" /></td>
			</tr>
			<tr>
				<th>Price(Rs.)</th>
				<td><form:input path="price" value="${menuItem.price}" /></td>
				<td><form:errors path="price" cssClass="errors" /></td>
			</tr>
			<tr>
				<th>Active</th>
				<td><form:radiobutton path="active" value="${menuItem.active}" />Yes<form:radiobutton
						path="active" value="${menuItem.active}" />No</td>
				<td><form:errors path="active" cssClass="errors" /></td>
			</tr>
			<tr>
				<th>Date Of Launch</th>
				<td><fmt:formatDate value="${menuItem.dateOfLaunch}" type="date" pattern="yyyy-MM-dd" var="theFormattedDate" /> 
						<form:input type="text" path="dateOfLaunch" value="${theFormattedDate}"/>
						
				<td><form:errors path="dateOfLaunch" cssClass="errors" /></td>
			</tr>
			<tr>
				<th>Category</th>
				<td><form:select path="category">
						<form:options items="${map}" />
					</form:select></td>
				<td><form:errors path="category" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><form:checkbox path="freeDelivery"/></td>
				<td>Free Delivery</td>
				<td><form:errors path="freeDelivery" cssClass="errors" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Save"></td>
			</tr>
		</table>


	</form:form>
</body>
</html>