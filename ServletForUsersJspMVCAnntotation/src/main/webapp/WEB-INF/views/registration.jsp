<%--
  Created by IntelliJ IDEA.
  User: nanoboot
  Date: 25.10.2016
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<script type="text/javascript">
    function validateForm()
    {
        var login=document.forms["Form"]["login"].value;
        var password=document.forms["Form"]["password"].value;
        var firstName=document.forms["Form"]["firstName"].value;
        var lastName=document.forms["Form"]["lastName"].value;
        var dateOfBirth=document.forms["Form"]["dateOfBirth"].value;
        var city=document.forms["Form"]["city"].value;
        if (!login || login.length === 0
                || !password || password.length === 0
                || !firstName || firstName.length === 0
                || !lastName || lastName.length === 0
                || !dateOfBirth
                || !city || city.length === 0)
        {
            alert("Заполните все поля!");
            return false;
        }
    }
</script>
    <h1>Registration</h1>
    <form name="Form" onsubmit="return validateForm()" action="registration" method="post">
        Login: <input type="text" name="login"> <br>
        Password <input type="password" name="password"> <br>
        First Name: <input type="text" name="firstName"> <br>
        Last Name: <input type="text" name="lastName"> <br>
        Date of birth: <input type="date" name="dateOfBirth" value="1990-06-01"> <br>
        City: <input type="text" name="city"> <br>
        <input type="submit" value="Registration">
    </form>
    <form>
        <input type="button" value="Login">
    </form>
</body>
</html>
