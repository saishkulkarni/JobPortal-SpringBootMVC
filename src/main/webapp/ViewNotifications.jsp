<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifications</title>
</head>
<body>
	<h1>Notifications</h1>
	<table border="1">
		<tr>
			<th>Message</th>
			<th>Time</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="notification" items="${notifications}">
			<tr>
				<th>${notification.message}</th>
				<th>${notification.time}</th>
				<th><a href="/user/delete-notification/${notification.id}"><button>Delete</button></a></th>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/user/back"><button>Back</button></a>
</body>
</html>