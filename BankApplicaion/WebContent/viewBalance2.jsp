<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Customer"%>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Balance</title>
</head>
<body>
<br>
<div align="center">
	<h1>
		View Balance
	</h1>
</div><br><br>
The balance of account ${account.accountId} is: $${account.balance}.
		<br><br>
	<div align="center">
		<br>
		<a href="home.jsp">Back to Home Page</a><br>
		<br>
	</div>
</body>
</html>