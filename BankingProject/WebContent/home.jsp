<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
		Home Page<br><br>
	</h1>
	<h2>
		Hello, ${customer.firstName}!
	</h2>
	<h3>
		What would you like to do?<br><br>
	</h3>
</div>
	<div align="center"><br>		
		<br><a href="viewBalance1.jsp">View Balance</a><br>
		<br><a href="accounts.jsp">View Accounts</a><br>
		<br><a href="createAccount.jsp">Create an Account</a><br>
		<br><a href="depositWithdrawal.jsp">Make a Deposit/Withdrawal</a><br>
		<br><a href="transferFunds.jsp">Transfer Funds Between Accounts</a><br>
		<br><a href="closeAccount.jsp">Close an Account</a><br>
		<br><a href="http://localhost:8080/BankingProject/LogOutServlet">Log Out</a><br><br><br><br><br><br><br>
	</div>
</body>
</html>