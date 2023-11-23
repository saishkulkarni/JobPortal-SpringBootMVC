<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User SignUp Page</title>
<style type="text/css">
fieldset{
    width: 450px;
}
</style>
</head>
<body>
    <h1><b><i>"User SignUp Page"</i></b></h1>
    <div>
    <form action="/user/signup" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>
                <b><i>Enter Your Details Here</i></b>
            </legend>
                <table>
                    <tr>
                        <th>NAME :</th>
                        <td><input type="text" class="non" name="name"></td>
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
                        <th>DATE OF BIRTH :</th>     
                        <td>                      
                            <input type="date" name="dob" required>
                        </td>
                    </tr>
                    <tr>
                        <th>GENDER :</th>
                        <td>MALE <input type="radio" name="gender" value="male">
                            FEMALE <input type="radio" name="gender" value="female">
                        </td>
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
    <a href="/user/login"><button>Back</button></a>
</body>
</html>