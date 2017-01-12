
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="container">
    <form name="Form" action="/registration" method=post id="register-form">
        <h2 class="form-signin-heading">Форма регистрации</h2>
        <ul>
            <li>
                <label for="email" class="sr-only">Email</label>
                <input type="text" name="email" id="email" size="25" class="form-control" placeholder="Введите Email" />
            </li>
            <li>
                <label for="username" class="sr-only">Логин</label>
                <input type="text" name="login" id="username" size="25" class="form-control" placeholder="Введите логин">
            </li>
            <li>
                <label for="password" class="sr-only">Пароль</label>
                <input type="password" size="15" name="password" id="password" class="form-control" placeholder="Введите пароль">
            </li>
            <li>
                <label for="country" class="sr-only">Страна</label>
                <input type="text" name="country" id="country" size="25" class="form-control" placeholder="Введите город">
            </li>
            <li>
                <label for="sex" class="sr-only">Пол</label>
                <select name="sex" id="sex" class="form-control" placeholder="Sex" >
                    <option selected value="M">М</option>
                    <option value="W">Ж</option>
                </select>
            </li>
        </ul>
        <input type="submit" onclick="return validate(this.form)" name="save" value="Зарегестрироваться" class="btn btn-lg btn-primary btn-block">
        <input type="reset" value="Сбросить поля" class="btn btn-lg btn-primary btn-block">
    </form>
</div>

<style>
    *:focus {outline: none;}
    body {font: 14px/21px "Lucida Sans", "Lucida Grande", "Lucida Sans Unicode", sans-serif;}
    .contact_form h2, .contact_form label {font-family:Georgia, Times, "Times New Roman", serif;}
    .contact_form ul {
        width:750px;
        list-style-type:none;
        list-style-position:outside;
        margin:0px;
        padding:0px;
    }
    .contact_form li{
        padding:12px;
        border-bottom:1px solid #eee;
        position:relative;
    }
    .contact_form li:first-child, .contact_form li:last-child {
        border-bottom:1px solid #777;
    }
    .contact_form h2 {
        margin:0;
        display: inline;
    }
    .contact_form label {
        width:150px;
        margin-top: 3px;
        display:inline-block;
        float:left;
        padding:3px;
    }
    .contact_form input {
        height:20px;
        width:220px;
        padding:5px 8px;
    }
    .contact_form textarea {padding:8px; width:300px;}
    .contact_form button {margin-left:156px;}
    .contact_form input, .contact_form textarea {
        border:1px solid #aaa;
        box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
        border-radius:2px;
    }
    .contact_form input:focus, .contact_form textarea:focus {
        background: #fff;
        border:1px solid #555;
        box-shadow: 0 0 3px #aaa;
    }
    .error input,
    .error textarea {
        border: 1px solid red;
    }
    .error { color: red; }
</style>

<script type="text/javascript">

    function showError(container, errorMessage) {
        container.className = 'error';
        var msgElem = document.createElement('span');
        msgElem.className = "error-message";
        msgElem.innerHTML = errorMessage;
        container.appendChild(msgElem);
    }

    function resetError(container) {
        container.className = '';
        if (container.lastChild.className == "error-message") {
            container.removeChild(container.lastChild);
        }
    }

    // функция валидации полей
    function validate(form) {
        var elems = form.elements;

        resetError(elems.email.parentNode);

        if (!elems.email.value) {
            showError(elems.email.parentNode, ' Укажите email!');
            return false;
        } else {
            var reg = /^([a-z0-9_\-]+\.)*[a-z0-9_\-]+@([a-z0-9][a-z0-9\-]*[a-z0-9]\.)+[a-z]{2,6}$/i;
            if (!reg.test(elems.email.value)) {
                showError(elems.email.parentNode, ' Email введен не корректно!');
                return false;
            }
        }

        resetError(elems.login.parentNode);
        if (!elems.login.value) {
            showError(elems.login.parentNode, ' Укажите логин!');
            return false;
        } else {
            var reg = /^[a-zA-Z](.[a-zA-Z0-9_-]*)$/;
            if (!reg.test(elems.login.value)) {
                showError(elems.login.parentNode, ' Логин введен не корректно! Используйте латинские сиволы и цифры!');
                return false;
            }
        }

        resetError(elems.password.parentNode);
        if (!elems.password.value) {
            showError(elems.password.parentNode, ' Укажите пароль!');
            return false;
        } else {
            if (elems.password.value.length < 8) {
                showError(elems.password.parentNode, ' Укажите пароль более 8 символов!');
                return false;
            }
        }

        resetError(elems.country.parentNode);
        if (!elems.country.value) {
            showError(elems.country.parentNode, ' Укажите страну!');
            return false;
        }
    }
</script>
</body>
</html>
