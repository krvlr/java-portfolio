
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
</head>
<body>

<br>Логин: ${userInfoJsp.name}
<br>Email: ${userInfoJsp.email}
<br>Страна: ${userInfoJsp.country}
<br>Пол: ${userInfoJsp.sex}

<form>
    <input type="button" value="Выйти" onclick="loginOut()">
</form>
<script language="JavaScript" type="text/javascript">
    function loginOut()
    {
        var cookie_date = new Date ( );
        cookie_date.setTime ( cookie_date.getTime() - 1);
        document.cookie = "token" + "=; expires=" + cookie_date.toGMTString();
        window.location='/login';
    }
</script>
</body>
</html>
