<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recruiter Login</title>
</head>
<body>
${pass}${fail}
	<h1>Recruiter Login</h1>
	<div class="container">
	<form action="/recruiter/login" method="post">
		<table>
			<tr>
				<th>Email:</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th colspan="2"><a href="/recruiter/forgot-password">Forgot Password?</a></th>
			</tr>
			<tr>
				<th colspan="2"><button>Login</button></th>
			</tr>
		</table>
		</form>
		<hr>
		<a href="/recruiter/signup"><button>Create Account</button></a>
	</div>
	<a href="/"><button>Back</button></a>
</body>
</html>