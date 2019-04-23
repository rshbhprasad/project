<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@CHARSET "ISO-8859-1";

html {
	size: landscape;
	background:
		url(https://images.pexels.com/photos/1919236/pexels-photo-1919236.jpeg?cs=srgb&dl=adult-career-clipboard-1919236.jpg&fm=jpg?dl&fit=crop&crop=entropy&w=1366&h=688);
}

h1 {
	color: #000;
}

h4 {
	size: auto;
	padding: 10px;
	width: 53px;
	height: 1px;
}

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

[type="date"] {
	background: #fff
		url(https://cdn1.iconfinder.com/data/icons/cc_mono_icon_set/blacks/16x16/calendar_2.png)
		97% 50% no-repeat;
}

[type="date"]::-webkit-inner-spin-button {
	display: none;
}

[type="date"]::-webkit-calendar-picker-indicator {
	opacity: 0;
}

.active {
	background-color: rgb(207, 100, 51);
}

h3 {
	opacity: 0.5;
	font-family: Calibri;
	font-size: 25pt;
	font-style: normal;
	font-weight: bold;
	color: SlateBlue;
	text-align: center;
	text-decoration: underline
}

table {
	font-family: Calibri;
	color: white;
	font-size: 11pt;
	font-style: normal;
	font-weight: bold;
	text-align:;
	background-color: #339966;
	border-collapse: collapse;
	border: 2px solid navy
}

table.inner {
	border: 5px
}
</style>



<!-- <link rel="stylesheet" href="style.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background:
		url(52897856-long-hospital-hallway-background-unfocused-.jpg);
	background-size: 100%;
	background-height: 100%;
}
</style>
<body>
	<ul>

		<li style="float: right"><a class="active"
			href="/Medical_Tourism1/logout">Log Out</a></li>

	</ul>

	<br>
	<br>
	<h1 align=center>Enter booking details...</h1>

	<div class="container">
		<div style="color: green">
			<c:if test="${not empty param.added}">
				<c:out value="${param.added}" />
			</c:if>
			<br> <br>
		</div>
		<div style="color: red">
			<c:if test="${not empty param.alert}">
				<c:out value="${param.alert}" />
			</c:if>
			<br> <br>
		</div>
		<form action="/Medical_Tourism1/user/add" class="was-validated"
			method="post">
			<div class="form-group">
				<label for="day">Day :</label> <input type="date" name="date"
					id="dateofbirth">
			</div>
			<div class="form-group">
				<label for="appt-time">Choose an appointment time (opening
					hours 09:00 to 18:00): </label> <input id="appt-time" type="time"
					name="time" min="09:00" max="18:00">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
