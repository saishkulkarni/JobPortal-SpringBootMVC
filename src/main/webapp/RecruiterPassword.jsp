<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recruiter Password</title>
</head>
<body>
${pass}${fail }
	<form action="/recruiter/reset-password" method="post">
		<input type="text" name="id" value="${id}" hidden="">
		Enter Otp:<input type="text" name="otp"><br> Enter New
		password:<input type="text" name="password">
		<button>Reset</button>
	</form>
</body>
</html>