<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applications</title>
</head>
<body>
<form action="/recruiter/view-application" method="post">
	Select A Job:
	<select name="id" required="required">
		<c:forEach var="job" items="${jobs}">
			<option value="${job.id}">${job.title}</option>
		</c:forEach>
	</select>
	<button>Submit</button>
</form>
	<br>
	<a href="/recruiter/back"><button>Back</button></a>

</body>
</html>