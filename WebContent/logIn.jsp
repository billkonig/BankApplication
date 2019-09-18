<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
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
		Please fill out the information below to log in.<br> Don't have
		an account? <a href="registration.jsp">Click here</a> to register for
		one.
	</h2>
	<br><br>
	<form class="container" action="LogInServlet" method="post">
		<br><br><div class="form-group">
			<input type="text" required="required"
				class="form-control" name="email" id="email" placeholder="Email">
		</div>
		<div class="form-group">
			<input type="password" required="required"
				class="form-control" name="password" id="password"
				placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<br><br>
	</form>
	</div>
</body>
</html>