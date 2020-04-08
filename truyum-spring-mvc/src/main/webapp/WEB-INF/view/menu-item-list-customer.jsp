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
<body  class="boxBorder">
<%@ include file="header2.jspf"%>
<h1>Menu Items</h1>
<c:out value="${addCartStatus ? 'Cart item Added Successfully' : ' '}"></c:out>
	<table>
		<tr>
			<th>Name</th>
			<td></td><td></td><td></td>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>

		<c:forEach var="menuItem" items="${custList}">
			<tr>
				<td>${menuItem.name}</td>
				<td></td><td></td><td></td>
				<td>${menuItem.freeDelivery}</td>
				<td>${menuItem.price}</td>
				<td>${menuItem.category}</td>
				<td><a href="add-to-cart?menuItemId=${menuItem.id}">Add To Cart</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jspf"%>
</body>
</html>