<%--
  Created by IntelliJ IDEA.
  User: nanoboot
  Date: 25.10.2016
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <script type="text/javascript">
        function validateForm()
        {
            var login=document.forms["Form"]["login"].value;
            var password=document.forms["Form"]["password"].value;
            if (login==null || login=="" || password==null || password=="")
            {
                alert("Заполните все поля");
                return false;
            }
        }
    </script>
    <h1>Login</h1>
    <form name="Form" onsubmit="return validateForm()" action="login" method="post">
        Login: <input type="text" name="login"> <br>
        Password <input type="password" name="password"> <br>
        <input type="submit" value="Login">
    </form>
    <form>
        <input type="button" value="Registration" onclick="window.location='/registration'">
    </form>
</body>
</html>
