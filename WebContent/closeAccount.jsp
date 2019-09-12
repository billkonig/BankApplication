<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<meta charset="ISO-8859-1">
<title>Close Account</title>
</head>
<body>
<br>
<div align="center">
	<h1>Close an Account</h1>
	<br><br>
	</div>
	<form action="CloseAccountServlet" method="post">
	Please enter the account ID of the account you wish to close:
	<br><div class="form-group">
			<label for="accountId">Account ID</label> <input type="text" required="required"
				class="form-control" name="accountId" id="accountId" placeholder="Account ID">
		</div>
		<button type="submit">Submit</button>
	</form>
	<br><br>
	<div align="center">
		<br><a href="home.jsp">Back to Home Page</a><br><br>
		</div>
</body>
</html>