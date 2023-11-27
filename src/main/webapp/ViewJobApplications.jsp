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
					<th>${application.user.name }</th>
					<th>${application.user.mobile }</th>
					<th>${application.job.title }</th>
					<th><a href="/recruiter/resume/${application.user.id}"><button>Download Resume</button></a></th>
					<th>${application.appliedDate }</th>
					<th><c:if test="${application.interviewDate==null}">
						NA
						</c:if> <c:if test="${application.interviewDate!=null}">
						${application.interviewDate}
						</c:if></th>
					<th>${application.jobStatus}</th>
					<th><c:if
							test="${application.jobStatus.name().equals('APPLIED')}">
							<a href="/recruiter/schedule/${application.id}"><button>Schedule Interview</button></a>
						</c:if> <c:if test="${application.jobStatus.name().equals('SCHEDULED')}">
							<a href="/recruiter/accept/${application.id}"><button>ACCEPT</button></a>
							<a href="/recruiter/reject/${application.id}"><button>REJECT</button></a>
						</c:if> <c:if
							test="${application.jobStatus.name().equals('SELECTED')||application.jobStatus.name().equals('REJECTED')}">
						NA
						</c:if></th>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<a href="/recruiter/back"><button>Back</button></a>

</body>
</html>