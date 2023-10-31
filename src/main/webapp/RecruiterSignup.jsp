<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
fieldset{
    width: 450px;
}
</style>
</head>
<body>
${fail}
    <h1><b><i>"Recruiter SignUp Page"</i></b></h1>
    <div>
    <form action="/recruiter/signup" method="post">
        <fieldset>
            <legend>
                <b><i>Enter Your Details Here</i></b>
            </legend>
                <table>
                    <tr>
                        <th>FULL NAME :</th>
                        <td><input type="text" class="non" name="fullname"></td>
                    </tr>
                    <tr>
                        <th>EMAIL :</th>
                        <td><input type="email" class="non" name="email"></td>
                    </tr>
                    <tr>
                        <th>MOBILE NUMBER :</th>
                        <td>
                            <input type="tel" pattern="[0-9]{10}" name="mobile"  class="non" required>
                        </td>
                    </tr>
                    <tr>
                        <th>PASSWORD :</th>
                        <td><input type="password" class="non" name="password"></td>
                    </tr>
                    <tr>
                        <th>GENDER :</th>
                        <td>MALE <input type="radio" name="gender" value="male">
                            FEMALE <input type="radio" name="gender" value="female">
                        </td>
                    </tr>
                    <tr>
                        <th>COMPANY NAME :</th>
                        <td><input type="text" class="non" name="companyname"></td>
                    </tr>
                    <tr>
                        <th>COMPANY LOCATION :</th>
                        <td><input type="text" class="non" name="companylocation"></td>
                    </tr>
                </table> 
                <br>
                <div>
                    <button>SignUp</button>
                    <button type="reset" id="cancel-button">Cancel</button>
                </div> 
        </fieldset>   
    </form>
    </div>
    <a href="/recruiter/login"><button>Back</button></a>
</body>
</html>