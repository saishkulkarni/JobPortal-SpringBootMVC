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
	Select A Job:
	<select onchange="seeApplication()">
		<c:forEach var="job" items="${jobs}">
			<c:set var="job" value="${job}" scope="application"></c:set>
			<option>${job.title}</option>
		</c:forEach>
	</select>

	<div id="applications" style="display: none">
		<table border="1px solid black">
			<tr>
				<th>User Name</th>
				<th>Applied Date</th>
				<th>Status</th>
				<th>Interview Date</th>
				<th>Download Resume</th>
				<th>Change Status</th>
			</tr>
			<c:forEach var="application" items="${job.applications}">
				<tr>
					<th>${application.user.fullname }</th>
					<th>${application.appliedDate }</th>
					<th>${application.jobStatus}</th>
					<th>${application.interviewDate }</th>
					<th><button>Download Resume</button></th>
					<th><button>Change Status</button></th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<a href="/recruiter/back"><button>Back</button></a>


	<script type="text/javascript">
		function seeApplication() {
			var div = document.getElementById('applications');
			if (div.style.display == 'none') {
				div.style.display = 'block';
			}
		}
	</script>
</body>
</html>