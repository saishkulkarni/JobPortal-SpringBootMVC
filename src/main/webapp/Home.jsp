<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
}

.container {
	margin: 20px;
	padding: 20px;
	display: flex;
	align-items: center;
	justify-content: center;
	display: flex;
	display: flex;
	border: 2px solid black;
	border-radius: 5px;
}

button {
	padding: 5px;
	border-radius: 2px;
	margin: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>Home Page</h1>
	<div class="container">
		<a href="/admin/login"><button>Admin</button></a> <a
			href="/recruiter/login"><button>Recruiter</button></a>
	<a href="/user/login">	<button>Job Seeker</button></a>
	</div>
</body>
</html>