<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Appointment</title>
<style type="text/css">
ul {
	list-style-type: none;
	margin-bottom: 50px;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	position: -webkit-sticky; /* Safari */
	position: sticky;
}

li {
	position: -webkit-sticky; /* Safari */
	position: sticky;
	color: white;
	float: left;
}

li:last-child {
	border-right: none;
	position: -webkit-sticky; /* Safari */
	position: sticky;
}

li a {
	border: #333;
	border-right: #333;
	border-left: #333;
	font-family: sans-serif;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	position: -webkit-sticky; /* Safari */
	position: sticky;
}

.active {
	background-color: rgb(207, 100, 51);
}
</style>
</head>
<body>
	<ul>

		<li style="float: right"><a class="active"
			href="/Medical_Tourism1/logout">Log Out</a></li>

	</ul>

	<br>
	<br>
	<h3 align=center>Select doctor to book appointment</h3>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Specialization</th>
					<th scope="col">Book</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="temp" items="${list}">
					<tr>
						<c:url var="book" value="/user/book">
							<c:param name="id" value="${temp.getDoctorID()}"></c:param>
						</c:url>
						<td>${temp.getName()}</td>
						<td>${temp.getSpecialization()}</td>
						<td><button type="button" class="btn btn-success"
								onclick="window.location.href='${book}&time=${time}&date=${date}' ;return false;">Book</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
