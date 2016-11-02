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
    <h1>Registration</h1>
    <form action="registration" method="post">
        Login: <input type="text" name="login"> <br>
        Password <input type="password" name="password"> <br>
        First Name: <input type="text" name="firstName"> <br>
        Last Name: <input type="text" name="lastName"> <br>
        Date of birth: <input type="date" name="dateOfBirth" value="1990-06-01"> <br>
        City: <input type="text" name="city"> <br>
        <input type="submit" value="Registration">
    </form>
    <form>
        <input type="button" value="Login" onclick="window.location='/login'">
    </form>
</body>
</html>
