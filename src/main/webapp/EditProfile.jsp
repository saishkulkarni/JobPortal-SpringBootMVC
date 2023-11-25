<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image:
		url("https://png.pngtree.com/thumb_back/fh260/back_our/20190628/ourmid/pngtree-feminine-blue-curve-background-vector-material-image_263788.jpg");
	background-repeat: no-repeat;
	background-size: 1500px 700px;
}

fieldset {
	background-color: white;
	width: 420px;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	margin: 20px auto;
}

legend {
	text-align: center;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

h1 {
	text-align: center;
	margin: 20px;
	color: darkred;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	font-size: 30px;
}

.non {
	border: 2px solid black;
	border-radius: 10px;
	height: 35px;
	width: 250px;
}

#button {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 20px;
}

#button01 {
	border: 1px black;
	border-radius: 8px;
	font-size: 18px;
	background-color: rgb(212, 212, 212);
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color: black;
	height: 30px;
	width: 92px;
	cursor: pointer;
}

#button01:hover {
	background-color: rgb(103, 155, 233);
}

#button02 {
	border: 2px black;
	background-color: grey;
	font-size: 20px;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	border-radius: 10px;
	height: 30px;
	width: 80px;
	cursor: pointer;
	margin: 10px 560px;
}

#button02:hover {
	background-color: rgb(103, 155, 233);
}
</style>
</head>
<body>
	<h1>
		<b>Edit Profile</b>
	</h1>
	<div>
		<form action="/user/profile" method="post"
			enctype="multipart/form-data">
			<input type="text" name="id" value="${user.id }" hidden="hidden">
			<fieldset>
				<legend>
					<b><i>Update Your Details</i></b>
				</legend>
				<table>
					<tr>
						<th>FULL NAME :</th>
						<td><input type="text" class="non" name="name"
							value="${user.name }"></td>
					</tr>
					<tr>
						<th>EMAIL :</th>
						<td><input type="email" class="non" name="email"
							value="${user.email}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>MOBILE NUMBER :</th>
						<td><input type="tel" pattern="[0-9]{10}" name="mobile"
							class="non" required value="${user.mobile}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>DATE OF BIRTH :</th>
						<td><input type="date" name="dob" required
							value="${user.dob}"></td>
					</tr>
					<tr>
						<th>GENDER :</th>
						<td>MALE <input type="radio" required name="gender"
							value="male"> FEMALE <input type="radio" required
							name="gender" value="female">
						</td>
					</tr>
					<tr>
						<th>HIGHEST DEGREE:</th>
						<td><input type="text" class="non" name="highestdegree"
							value="${user.highestdegree}" required></td>
					</tr>
					<tr>
						<th>10th Percentage:</th>
						<td><input type="text" class="non" name="tenthPercentage"
							value="${user.tenthPercentage}" required></td>
					</tr>
					<tr>
						<th>12th Percentage:</th>
						<td><input type="text" class="non" name="twelthPercentage"
							value="${user.twelthPercentage }" required></td>
					</tr>
					<tr>
						<th>Degree Percentage:</th>
						<td><input type="text" class="non" name="degreePercenatge"
							value="${user.degreePercenatge }" required></td>
					</tr>
					<tr>
						<th>Master Percentage:</th>
						<td><input type="text" class="non" name="masterPercentage"
							value="${user.masterPercentage }"></td>
					</tr>
					<tr>
						<th>Resume:</th>
						<td><input type="file" class="non" name="res"></td>
					</tr>
				</table>
				<br>
				<div>
					<button>Update</button>
					<button type="reset" id="cancel-button">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<a href="/user/back"><button>
			<b>BACK</b>
		</button></a>

</body>
</html>