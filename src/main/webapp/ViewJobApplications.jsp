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
<div id="applications">
		<table border="1px solid black">
				<tr>
					<th>Applicant Name</th>
					<th>Mobile</th>
					<th>Role Applied</th>
					<th>Download Resume</th>
					<th>Applied Date</th>
					<th>Interview Date</th>
					<th>Current Status</th>
					<th>Change Status</th>
				</tr>

				<c:forEach var="application" items="${applications}">
					<tr>
						<th>${application.user.fullname }</th>
						<th>${application.user.mobile }</th>
						<th>${application.job.title }</th>
						<th><button>Download Resume</button></th>
						<th>${application.appliedDate }</th>
						<th>
						<c:if test="${application.interviewDate==null}">
						NA
						</c:if>
						<c:if test="${application.interviewDate!=null}">
						${application.interviewDate}
						</c:if>
						</th>
						<th>${application.jobStatus}</th>
						<th><button>Change Status</button></th>
					</tr>
				</c:forEach>
			</table>
	</div>
<br>
	<a href="/recruiter/back"><button>Back</button></a>

</body>
</html>