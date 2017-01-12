<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Главная!</title>

    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" rel="stylesheet" src="js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
    <script type="text/javascript" src="js/scroll.js"></script>

</head>

<body>

<div id="main">

    <h1>Musical grammar</h1>

    <div id="gallery">

        <div id="slides">
            <div class="slide">
                <img src="img/sample_slides/macbook.jpg" width="920" height="400" alt="side"/>
                <span> Если ты хочешь обучиться нотной грамоте, то ты по адресу!</span>
            </div>

            <div class="slide">
                <img src="img/sample_slides/iphone.jpg" width="920" height="400" alt="side"/>
                <span> Слушай мои видеоуроки! Качай скилл!</span>
            </div>

            <div class="slide">
                <img src="img/sample_slides/imac.jpg" width="920" height="400" alt="side"/>
                <span>Оценивай видео, пиши комменты и добавления!</span>
            </div>

            <div class="slide">
                <img src="img/sample_slides/info.jpg" width="920" height="400" alt="side"/>
                <span> Если интересно, кликай внизу на стрелку и вперед!</span>
            </div>

        </div>

        <div id="menu">
            <ul>
                <li class="fbar">&nbsp;</li>
                <li class="menuItem"><a href=""><img src="img/sample_slides/thumb_macbook.png" width="24"
                                                     height="24" alt="thumbnail"/></a></li>
                <li class="menuItem"><a href=""><img src="img/sample_slides/thumb_iphone.png" width="24"
                                                     height="24" alt="thumbnail"/></a></li>
                <li class="menuItem"><a href=""><img src="img/sample_slides/thumb_imac.png" width="24" height="24"
                                                     alt="thumbnail"/></a></li>
                <li class="menuItem"><a href=""><img src="img/sample_slides/thumb_about.png" width="24"
                                                     height="24" alt="thumbnail"/></a></li>
            </ul>
        </div>

    </div>
    <div class="go-up" title="Вверх" id='ToTop'>&#8657;</div>
    <div class="go-down" title="Вниз" id='OnBottom'>&#8659;</div>

</div>
<div class="registration">
    <form id="login" method = "POST">
        <h1>Форма входа</h1>
        <fieldset id="inputs">
            <input name = "userName" id="userName" type="text" placeholder="Логин" autofocus required>
            <input name = "password" id="password" type="password" placeholder="Пароль" required>
        </fieldset>
        <fieldset id="actions">
            <input type="submit" id="submit" value="Войти">
            <a href="registration">Регистрация</a>
        </fieldset>
    </form>
</div>
</body>
</html>


