<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add owner</title>
</head>
<body>
    <form action="users" method="get">
        <h1> Add owner </h1>
        First Name: <input type="text" name="firstName"> <br>
        Last Name: <input type="text" name="lastName"> <br>
        Date of birth <input type="date" name="dateOfBirth" value="1990-06-01"> <br>
        City: <input type="text" name="city"> <br>
        <input type="submit" value="Add new owner">
    </form>
</body>
</html>