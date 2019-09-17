<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Customer"%>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Funds</title>
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
		Transfer Funds Between Accounts
	</h1>
<br><br>
<form action="TransferFundsServlet" method="post">	
	<br><div class="form-group">
			<label for="accountId1">Enter account ID of account to transfer funds from:</label> <input type="text" required="required"
				class="form-control" name="accountId1" id="accountId1" placeholder="Account ID">
		</div>	
	<div class="form-group">
			<label for="accountId2">Enter account ID of account to transfer funds to:</label> <input type="text" required="required"
				class="form-control" name="accountId2" id="accountId2" placeholder="Account ID">
		</div>	
	<div class="form-group">
			<label for="amount">Enter amount of money you wish to transfer:</label><br> <span>$<input
				type="text" required="required" name="amount" id="amount" placeholder="0.00" /></span><br>
		</div>		
		<button type="submit" class="btn btn-primary">Submit</button></form>
		<br><br>
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>
</body>
</html>