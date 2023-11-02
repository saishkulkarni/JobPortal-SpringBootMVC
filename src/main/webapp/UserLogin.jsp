<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
${pass}${fail }
	<h1>User Login</h1>
	<div class="container">
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
				<th colspan="2"><a href="#">Forgot Password?</a></th>
			</tr>
			<tr>
				<th colspan="2"><button>Login</button></th>
			</tr>
		</table>
		<hr>
		<a href="/user/signup"><button>Create Account</button></a>
	</div>
	<a href="/"><button>Back</button></a>
</body>
</html>