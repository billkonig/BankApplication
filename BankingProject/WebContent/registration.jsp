<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<br>
<div align="center">
	<h1>Welcome to RoboBank & Trust!</h1>
	<br>
	<h2>
		Please fill out the information below to register for a new account.<br>
	</h2>
</div>
	<form class="container" action="RegistrationServlet" method="post">
		<br>
		<h4>Personal Information</h4>
		Please enter your personal information:<br>
		<div class="form-group">
			<label for="firstName">First Name</label> <input type="text" required="required"
				class="form-control" name="firstName" id="firstName"
				placeholder="First Name">
		</div>
		<div class="form-group">
			<label for="lastName">Last Name</label> <input type="text" required="required"
				class="form-control" name="lastName" id="lastName"
				placeholder="Last Name">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="text" required="required"
				class="form-control" name="email" id="email" placeholder="Email">
		</div>
		<br>
		<h4>Address Information</h4>
		Please enter your address information:<br>
		<div class="form-group">
			<label for="street">Street</label> <input type="text" required="required"
				class="form-control" name="street" id="street" placeholder="Street">
		</div>
		<div class="form-group">
			<label for="city">City</label> <input type="text" required="required"
				class="form-control" name="city" id="city" placeholder="City">
		</div>
		<div class="form-group">
			<label for="state">State</label> <input type="text" required="required"
				class="form-control" name="state" id="state" placeholder="State">
		</div>
		<div class="form-group">
			<label for="zipCode">Zip Code</label> <input type="text" required="required"
				class="form-control" name="zipCode" id="zipCode"
				placeholder="Zip Code">
		</div>
		<br>
		<h4>Password</h4>
		Please set your password:
		<div class="form-group">
			<label for="Password">Password</label> <input type="password" required="required"
				class="form-control" name="password" id="password"
				placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<br><br>
	</form>
</body>
</html>