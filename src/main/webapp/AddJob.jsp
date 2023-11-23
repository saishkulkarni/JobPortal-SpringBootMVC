<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
<style type="text/css">
#tab {
	text-align: center;
	border: 2px solid black;
	width: 500px;
	margin: 30px auto;
}

input {
	margin: 10px 0px;
	height: 25px;
	width: 350px;
}
</style>
</head>
<body>
	<form action="/recruiter/add-job" method="post">
		<table id="tab">
			<tr>
				<th>Enter Job Title:</th>
			</tr>
			<tr>
				<td><input type="text" class="non" name="title"></td>
			</tr>
			<tr>
				<th>Enter Skills Required :</th>
			</tr>
			<tr>
				<td><input type="text" class="non" name="skills"></td>
			</tr>
			<tr>
				<th>Enter Job Decription :</th>
			</tr>
			<tr>
				<td><input type="text" name="description" class="non"></td>
			</tr>
			<tr>
				<th>Experience Required In Years :</th>
			</tr>
			<tr>
				<td><input type="text" class="non" name="experience"></td>
			</tr>
			<tr>
				<th>Package :</th>
			</tr>
			<tr>
				<td><input type="text" class="non" name="ctc">LPA</td>
			</tr>
			<tr>
				<th>Location :</th>
			</tr>
			<tr>
				<td><input type="text" class="non" name="location"></td>
			</tr>
			<tr>
				<th>Number of Positions :</th>
			</tr>
			<tr>
				<td><input type="number" class="non" name="numberOfPositions"></td>
			</tr>
			<tr>
				<td>
					<button>
						<b>ADD</b>
					</button>
					<button type="reset" id="cancel-button">
						<b>CANCEL</b>
					</button>
				</td>
			</tr>
		</table>
	</form>
	<br>
	<a href="/recruiter/back"><button>Back</button></a>
</body>
</html>