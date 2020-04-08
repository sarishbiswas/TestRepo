<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style><%@include file="/WEB-INF/view/style.css"%></style>
<title>Insert title here</title>
</head>
<body class="boxBorder">
<%@ include file="header1.jspf"%>
<h1>Menu Items</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>

		<c:forEach var="menuItem" items="${adminList}">
			<tr>
				<td>${menuItem.name}</td>
				<td>${menuItem.price}</td>
				<td>${menuItem.active}</td>
				<td>${menuItem.dateOfLaunch}</td>
				<td>${menuItem.category}</td>
				<td>${menuItem.freeDelivery}</td>
				<td><a href="show-edit-menu-item?menuItemId=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>


	</table>
	<%@ include file="footer.jspf"%>
</body>
</html>