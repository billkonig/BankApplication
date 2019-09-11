<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.user.Customer"%>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href=z"./styles/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>
<br>
<div align="center">
	<h1>Create an Account</h1>
	<br><br>
	</div>
	<form action="CreateAccountServlet" method="post">
	Choose an account ID: (Can be a name, a number, or both.)
	<br><div class="form-group">
			<label for="accountId">Account ID</label> <input type="text" required="required"
				class="form-control" name="accountId" id="accountId" placeholder="Account ID">
		</div>
		Select account type: <select class="form-control" name="checkSave">
			<br><option value="Checking">Checking</option>
			<option value="Saving">Saving</option>
		</select> <br>Would you like to enroll in overdraft protection?
		(If yes, this will disallow you from withdrawing funds from your
		account after it reaches $0. If no, you will be allowed to withdraw
		funds up to $500 after your account reaches $0, but with an overdraft
		fee of $30 per withdrawal.)<br>
		<div class="form-check form-check-inline">
			<br><input class="form-check-input" type="radio" required="required"
				name="odp" id="odp" value="Yes"> <label
				class="form-check-label" for="inlineRadio1">Yes</label>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" required="required"
				name="odp" id="odp" value="No"> <label
				class="form-check-label" for="inlineRadio2">No</label>
		</div>
		<br><br>How much money would you like to deposit in your
		new account? (An initial deposit is required to open
		a bank account here at RB&T.)
		<br><div class="form-group">
			<label for="balance">Deposit</label><br> <span>$<input
				type="text" required="required" name="balance" id="balance" placeholder="0.00" /></span><br>
		</div>​
		<button type="submit">Submit</button>
	</form>
	<br><br>
	<div align="center">
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>​
</body>
</html>