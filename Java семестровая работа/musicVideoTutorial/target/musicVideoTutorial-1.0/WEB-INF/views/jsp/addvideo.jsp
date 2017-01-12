<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового видеоурока</title>
</head>
<body>
    <form name="Form" action="/addvideo" method=post>
        <h2>Форма добавления видеурока</h2>
        <label for="description">Описание</label>
        <input type="text" name="description" id="description" placeholder="Введите описание" /> <br>
        <input type="submit" onclick="window.location='/addvideo'" name="save" value="Добавить">
        <input type="button" value="Перейти к списку видео уроков" onclick="window.location='/listvideo'">
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
