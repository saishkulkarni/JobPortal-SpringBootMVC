<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Applications</title>
</head>
<body>
	<h1>Applied Job Details</h1>
	<table border="1">

		<tr>
			<th>Company Name</th>
			<th>Role</th>
			<th>Package</th>
			<th>Location</th>
			<th>Applied Date</th>
			<th>Interview Date</th>
			<th>Current Status</th>
		</tr>

		<c:forEach var="application" items="${applications}">
			<tr>
				<th>${application.job.recruiter.companyname}</th>
				<th>${application.job.title }</th>
				<th>${application.job.ctc}</th>
				<th>${application.job.location}</th>
				<th><c:set var="format"
						value="${DateTimeFormatter.ofPattern('dd-MMM-yyyy HH:mm')}"></c:set>
					<c:out value="${application.appliedDate.format(format)}"></c:out></th>
				<th><c:if test="${application.interviewDate==null}">
				Not Scheduled Yet
				</c:if> <c:if test="${application.interviewDate!=null}">
						<c:set var="format"
							value="${DateTimeFormatter.ofPattern('dd-MMM-yyyy HH:mm')}"></c:set>
						<c:out value="${application.interviewDate.format(format)}"></c:out>
					</c:if></th>
				<th>${application.jobStatus}</th>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/user/back"><button>Back</button></a>
</body>
</html>