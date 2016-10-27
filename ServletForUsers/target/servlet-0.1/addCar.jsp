<%--
  Created by IntelliJ IDEA.
  User: nanoboot
  Date: 25.10.2016
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add auto</title>
</head>
<body>
    <h1>Add auto</h1>
    <form action="addCar" method="post">
        Brand: <input type="text" name="brand"> <br>
        Model: <input type="text" name="model"> <br>
        Mileage: <input type="text" name="mileage"> <br>
        Colour: <input type="text" name="colour"> <br>
        <input type="submit" value="Add car">
    </form>
    <form>
        <input type="button" value="Login" onclick="window.location='/list'">
    </form>
</body>
</html>
