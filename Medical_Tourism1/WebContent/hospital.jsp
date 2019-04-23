<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Hospital</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1></h1>
	<br>
	<button onclick="window.location.href = '/Medical_Tourism1/logout';">Logout</button>
	<div class="container">
		<div style="color: green">
			<c:if test="${not empty param.added}">
				<c:out value="${param.added}" />
			</c:if>
			<br>
			<br>
		</div>
		<form action="/Medical_Tourism1/hospital/add" class="was-validated"
			method="post">
			<div class="form-group">
				<label for="sp">Specialization :</label> <input type="text"
					class="form-control col-sm-6" id="sp"
					placeholder="Enter Specialization" name="sp" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="day">Day of availability :</label> <input type="text"
					class="form-control col-sm-6" id="day"
					placeholder="Enter day of availability" name="day" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>