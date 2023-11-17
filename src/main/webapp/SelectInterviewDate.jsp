<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/recruiter/schedule" method="post">
		<input type="text" name="id" value="${id}" hidden="hidden">
		Enter Schedule Date:<input type="datetime-local" name="interviewDate" required="required">
		<button>Schedule</button>
	</form>
</body>
</html>