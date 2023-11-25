<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body>
${pass}${fail}
<h1>Job Seeker Home</h1>
<c:if test="${!user.prime}">
<a href="/user/buy-prime"><button>Buy Prime</button></a>
</c:if>
<a href="/user/view-jobs"><button>Jobs</button></a>
<a href="/user/view-application"><button>See My Application</button></a>
<a href="/user/notifications"><button>Notifications</button></a>
<a href="/user/profile"><button>Edit Profile</button></a>
<a href="/logout"><button>Logout</button></a>
</body>
</html>