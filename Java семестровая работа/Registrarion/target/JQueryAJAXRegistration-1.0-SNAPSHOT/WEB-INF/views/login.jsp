<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти!</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <script type="text/javascript" rel="stylesheet" src="jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" rel="stylesheet" src="jquery/loginValidation.js"></script>
</head>

<body>
<div class="form_box">
    <form id="login" method="POST" class="rf" action="#">
        <h1>Войти</h1>
        <label for="userName">Логин</label>
        <input type="text" name="userName" id="userName" size="25" class="rfield" placeholder="Login" autofocus required/>

        <label for="password">Пароль</label>
        <input type="password" name="password" id="password" size="25" class="rfield" placeholder="Password" required>

        <input type="submit" class="btn_submit" value="Войти">
        <input type="button" class="btn_submit" onclick="window.location='/registration'" value="Регистрация">
    </form>
</div>
</body>
</html>


