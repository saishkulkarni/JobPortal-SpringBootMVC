<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Details Below</h1>
<form action="/user/experience/apply" method="post">
<input type="text" name="id" value="${id}" hidden="">
Years of Experience:<input type="number" name="years" ><br>
Previous Role Description:<input type="text" name="description"><br>
Notice Period Till:<input type="date" name="notice"><br>
<button>Apply</button> 
</form>
</body>
</html>