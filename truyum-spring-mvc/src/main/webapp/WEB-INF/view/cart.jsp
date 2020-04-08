<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/view/style.css"%></style>
<title></title>
</head>
<body class="boxBorder">
<%@ include file="header2.jspf"%>
<h1>Cart</h1>
<c:out value="${removeCartStatus ? 'Cart item Removed Successfully' : ' '}"></c:out>
	<table>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th></th>
		</tr>

		<c:forEach var="menuItem" items="${cart.menuItemList}">
			<tr>
				<td>${menuItem.name}</td>
				<td>${menuItem.freeDelivery}</td>
				<td>${menuItem.price}</td>
				<td><a href="remove-cart?menuItemId=${menuItem.id}">Delete</a></td>
			</tr>
		</c:forEach>
<tr><td></td><td>Total</td><td>${cart.total}</td><td></td></tr>
	</table>
	<%@ include file="footer.jspf"%>
</body>
</html>