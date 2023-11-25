<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Duration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Admin Jobs</title>
</head>
<body>
	<h1>All Job Details</h1>
	<table border="1">
		<tr>
			<th>Job Role</th>
			<th>Job Description</th>
			<th>Salary Package</th>
			<th>Experience</th>
			<th>Location</th>
			<th>Posted</th>
			<th>Status</th>
		</tr>
		<c:forEach var="job" items="${jobs}">
			<tr>
				<td>${job.title }</td>
				<td>${job.description}</td>
				<td>${job.ctc}</td>
				<td>${job.experience}</td>
				<td>${job.location}</td>
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
				<td><a href="/admin/change-status/${job.id}"><button>
							<c:if test="${job.approved}">
			Disapprove
			</c:if>
							<c:if test="${!job.approved}">
			Approve
			</c:if>
						</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/admin/back"><button>Back</button></a>
</body>
</html>