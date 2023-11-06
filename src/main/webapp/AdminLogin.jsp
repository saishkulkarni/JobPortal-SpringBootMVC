<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
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
${pass }${fail }
	<h1>Admin Login</h1>
	<div class="container">
		<form action="/admin/login" method="post">
			<table>
				<tr>
					<th>Email:</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th colspan="2"><button>Login</button></th>
				</tr>
			</table>
		</form>
	</div>
	<a href="/"><button>Back</button></a>
</body>
</html>