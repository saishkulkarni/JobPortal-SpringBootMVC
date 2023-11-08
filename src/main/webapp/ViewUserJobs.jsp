<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User Jobs</title>
</head>
<body>
${fail}${pass}
	<h1>All Job Details</h1>
	<table border="1">
		<tr>
			<th>Job Role</th>
			<th>Job Description</th>
			<th>Salary Package</th>
			<th>Experience</th>
			<th>Location</th>
			<th>Apply</th>
		</tr>
		<c:forEach var="job" items="${jobs}">
			<tr>
				<td>${job.title }</td>
				<td>${job.description}</td>
				<td>${job.ctc}</td>
				<td>${job.experience}</td>
				<td>${job.location}</td>
				<td><a href="/user/apply-job/${job.id}"><button>
							Apply</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/user/back"><button>Back</button></a>
</body>
</html>