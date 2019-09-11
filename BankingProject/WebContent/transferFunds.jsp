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
</div>
<br>
<form action="TransferFundsServlet" method="post">
	Enter account ID of account to transfer funds from:
	<div class="form-group">
			<br><label for="accountId1">Account ID</label> <input type="text" required="required"
				class="form-control" name="accountId1" id="accountId1" placeholder="Account ID">
		</div>
	Enter account ID of account to transfer funds to:
	<div class="form-group">
			<br><label for="accountId2">Account ID</label> <input type="text" required="required"
				class="form-control" name="accountId2" id="accountId2" placeholder="Account ID">
		</div>
	Enter amount of money you wish to transfer:
	<div class="form-group">
			<br><label for="amount">Amount</label><br> <span>$<input
				type="text" required="required" name="amount" id="amount" placeholder="0.00" /></span><br>
		</div>		
		<button type="submit" class="btn btn-primary">Submit</button></form>
		<br><br>
		<div align="center">
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>
</body>
</html>