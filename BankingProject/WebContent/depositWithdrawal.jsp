<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Customer"%>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit/Withdrawal</title>
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
		Make a Deposit or Withdrawal
	</h1>
</div>
<br>
<form action="DepositWithdrawalServlet" method="post">
	Enter account ID of account to make deposit to/withdrawal from:
	<div class="form-group">
			<br><label for="accountId">Account ID</label> <input type="text" required="required"
				class="form-control" name="accountId" id="accountId" placeholder="Account ID">
		</div>
		<div class="form-group">
			<label for="deposit">Deposit</label><br> <span>$<input
				type="text" required="required" name="deposit" id="deposit" placeholder="0.00" /></span><br>
		</div>
		<div class="form-group">
			<label for="withdrawal">Withdrawal</label><br> <span>$<input
				type="text" required="required" name="withdrawal" id="withdrawal" placeholder="0.00" /></span><br>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button></form>
		<br><br>
		<div align="center">
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>
</body>
</html>