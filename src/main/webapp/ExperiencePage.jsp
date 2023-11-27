<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Duration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/user/experience" method="post">
		<input type="text" name="id" value="${id}" hidden=""> Are you
		Experienced : <input type="radio" name="experience" value="yes">Yes
		<input type="radio" name="experience" value="no">No <br>
		<button>Apply</button>
		<button type="reset">Cancel</button>
	</form>
</body>
</html>