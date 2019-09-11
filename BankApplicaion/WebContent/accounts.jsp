<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Customer"%>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<br>
<div align="center">
	<h1>
		Your Accounts
	</h1>
</div>
<br>
	${customer.accounts}
	<br><br>
	<div align="center">
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>
</body>
</html>