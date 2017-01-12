
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <script type="text/javascript" rel="stylesheet" src="jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" rel="stylesheet" src="jquery/registrationValidation.js"></script>
</head>
<body>
<div class="form_box">
    <form id="registration" method="POST" class="rf" action="#">
        <h1>Регистрация</h1>
        <label for="email">Email</label>
        <input type="text" name="email" id="email" class="rfield" size="25" placeholder="Введите Email" />
        <div class="error-box"></div>
        <label for="username">Логин</label>
        <input type="text" name="username" id="username" class="rfield" size="25" placeholder="Введите логин">
        <div class="error-box"></div>
        <label for="password">Пароль</label>
        <input type="password" name="password" id="password" class="rfield" size="25" placeholder="Введите пароль">
        <div class="error-box"></div>
        <label for="country">Страна</label>
        <input type="text" name="country" id="country" class="rfield" size="25" placeholder="Введите город">
        <div class="error-box"></div>
        <label for="sex">Пол</label>
        <select name="sex" id="sex" placeholder="Sex" >
            <option selected value="M">Муж</option>
            <option value="W">Жен</option>
        </select>
        <br>
        <input type="submit" class="btn_submit disabled" value="Зарегестрироваться"><!--onclick="return validate(this.form)"-->
        <input type="reset" class="btn_clear" value="Сбросить поля">
    </form>
</div>
</body>
</html>
