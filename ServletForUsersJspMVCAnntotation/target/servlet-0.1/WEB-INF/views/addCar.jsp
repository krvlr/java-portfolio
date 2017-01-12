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
<script type="text/javascript">
    function validateForm()
    {
        var brand=document.forms["Form"]["brand"].value;
        var model=document.forms["Form"]["model"].value;
        var mileage=document.forms["Form"]["mileage"].value;
        var colour=document.forms["Form"]["colour"].value;
        if (!brand || brand.length === 0||
                !model || model.length == 0 ||
                !mileage || mileage.length === 0 ||
                !colour || colour.length === 0)
        {
            alert("Заполните все поля!");
            return false;
        }
    }
</script>
    <h1>Add auto</h1>
    <form action="addCar" onsubmit="return validateForm()" method="post">
        Brand: <input type="text" name="brand"> <br>
        Model: <input type="text" name="model"> <br>
        Mileage: <input type="text" name="mileage"> <br>
        Colour: <input type="text" name="colour"> <br>
        <input type="submit" value="Add car">
    </form>
    <script language="JavaScript" type="text/javascript">
    function loginOut()
    {
        var cookie_date = new Date ( );
        cookie_date.setTime ( cookie_date.getTime() - 1 );
        document.cookie = "token" + "=; expires=" + cookie_date.toGMTString();
        window.location='/login';
    }
</script>
    <form>
        <input type="button" value="Login out" onclick="loginOut()">
    </form>
</body>
</html>
