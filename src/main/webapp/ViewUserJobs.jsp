<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Duration"%>
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
			<th>Skills Required</th>
			<th>Experience</th>
			<th>Location</th>
			<th>Number of Positions</th>
			<th>Posted</th>
			<th>Apply</th>
		</tr>
		<c:forEach var="job" items="${jobs}">
			<tr>
				<td>${job.title }</td>
				<td>${job.description}</td>
				<td>${job.ctc}</td>
				<th>${job.skills}</th>
				<td>${job.experience}</td>
				<td>${job.location}</td>
				<td>${job.numberOfPositions}
				<td><c:set var="duration"
						value="${Duration.between(job.postedTime, LocalDateTime.now())}"></c:set>
					<c:choose>
						<c:when test="${duration.toDays()==0}">
							<c:choose>
								<c:when test="${duration.toHours()==0 }">
									<c:choose>
										<c:when test="${duration.toMinutes()==0 }">
						 ${duration.toSeconds()} Seconds ago
						</c:when>
										<c:otherwise>
					    ${duration.toMinutes()} Minutes ago
						</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
				     ${duration.toHours()} Hours ago
					</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
			     ${duration.toDays()} Days Ago
				</c:otherwise>
					</c:choose></td>
				<td><a href="/user/check-job/${job.id}"><button>
							Apply</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/user/back"><button>Back</button></a>
</body>
</html>