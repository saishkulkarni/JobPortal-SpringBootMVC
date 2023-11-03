<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Email</title>
</head>
<body>
${fail }${pass }
<form action="/recruiter/forgot-password" method="post">
Enter Email:<input type="text" name="email">
<button>Submit</button>
</form>
</body>
</html>