<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${pass}${fail }
	<form action="/recruiter/verify-otp" method="post">
		<input type="text" name="id" value="${id}" hidden="hidden">
		Enter OTP:<input type="text" name="otp">
		<button>Submit</button>
	</form>
	<a href="/recruiter/resend-otp/${id}"><button id="resendButton">Resend
			Otp</button></a>
	<script>
		var resendButton = document.getElementById("resendButton");
		var timer;

		function disableButton() {
			resendButton.disabled = true;

			var seconds = 30;
			timer = setInterval(function() {
				resendButton.innerHTML = "Resend Otp (" + seconds + "s)";
				seconds--;

				if (seconds < 0) {
					clearInterval(timer);
					resendButton.innerHTML = "Resend Otp";
					resendButton.disabled = false;
				}
			}, 1000); // 1000 milliseconds = 1 second
		}

		// Call this function when the page loads to set the initial state
		window.onload = function() {
			disableButton();
		};

		// Optionally, you can clear the timer when the user leaves the page
		window.onunload = function() {
			clearInterval(timer);
		};
	</script>
</body>
</html>
