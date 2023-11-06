<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
${pass}${fail }
	<h1>Home Page</h1>
	<div class="container">
		<a href="/admin/login"><button>Admin</button></a> <a
			href="/recruiter/login"><button>Recruiter</button></a>
	<a href="/user/login">	<button>Job Seeker</button></a>
	</div>
</body>
</html>