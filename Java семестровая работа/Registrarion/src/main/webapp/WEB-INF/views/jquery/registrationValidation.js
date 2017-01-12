$(document).ready(function () {

    // Выполнение функции после загрузки
    $('.rf').each(function () {
        // Объявляем переменные (форма и кнопка отправки)
        var form = $(this), btn = form.find('.btn_submit');

        // Добавляем каждому проверяемому полю, указание что некорректно
        form.find('.rfield').addClass('incorrect_field');

        // Проверка корректности всех полей в режиме реального времени
        setInterval(function () {
            // Считаем количество неправильно заполненных полей
            var sizeEmpty = form.find('.incorrect_field').size();
            // Вешаем условие-тригер на кнопку отправки формы
            if (sizeEmpty > 0) {
                if (btn.hasClass('disabled')) {
                    return false;
                } else {
                    btn.addClass('disabled');
                }
            } else {
                btn.removeClass('disabled');
            }
        }, 500);
    });

    // Событие по нажатию кники submit
    $('form#form_box').submit(function(e) {
        e.preventDefault();
        if ($(this).hasClass('disabled')) {
            return false;
        } else {
            $(this).submit();
        }
    });

    // Событие по потере фокуса с полей ввода
    $('input#email, input#username, input#password, input#country').unbind().blur(function () {
        var id = $(this).attr('id');
        var val = $(this).val();
        switch (id) {
            case 'email':
                var rv_email = /^([a-z0-9_\-]+\.)*[a-z0-9_\-]+@([a-z0-9][a-z0-9\-]*[a-z0-9]\.)+[a-z]{2,6}$/;
                if (val != '' && rv_email.test(val)) {
                    // Проверка существования email с запросом на сервер
                    $.ajax
                    ({
                        url: "/check/email",
                        type: "POST",//Метод передачи
                        data: {"email":val},//Отправляемые данные
                        dataType: "text",
                        success: function(data)//Если запрос удачен
                        {
                            if (data == 'ok') { // Если все нормально
                                $('#email').removeClass('incorrect_field');
                                $('#email').css({'border': '1px solid #569b44'});
                                $('#email').next('.error-box').text('Принято')
                                    .css('color', 'green')
                                    .animate({'paddingLeft': '10px'}, 400)
                                    .animate({'paddingLeft': '5px'}, 400);
                            } else {
                                if (data == 'error') {
                                    $('#email').addClass('incorrect_field');
                                    $('#email').css({'border': '1px solid #ff0000'});
                                    $('#email').next('.error-box').html('Пользователь с таким email адресом уже существует!<br>')
                                        .css('color', 'red')
                                        .animate({'paddingLeft': '10px'}, 400)
                                        .animate({'paddingLeft': '5px'}, 400);
                                }
                            }
                        },
                        error: function(e)
                        {
                            $('#email').addClass('incorrect_field');
                            $('#email').css({'border': '1px solid #ff0000'});
                            $('#email').next('.error-box').html('Проверка совпадений email адреса не удалась!<br>')
                                .css('color', 'red')
                                .animate({'paddingLeft': '10px'}, 400)
                                .animate({'paddingLeft': '5px'}, 400);
                        }
                    });
                } else {
                    $(this).addClass('incorrect_field');
                    $(this).css({'border': '1px solid #ff0000'});
                    $(this).next('.error-box').html('Email-адрес не введен или введен неверно!<br>')
                        .css('color', 'red')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                }
                break;
            case 'username':
                var rv_username = /^[a-zA-Z](.[a-zA-Z0-9_-]*)$/;
                if (val.length > 2 && val != '' && rv_username.test(val)) {
                    // Проверка существования email с запросом на сервер
                    $.ajax
                    ({
                        url: "/check/login",
                        type: "POST",//Метод передачи
                        data: {"login":val},//Отправляемые данные
                        dataType: "text",
                        success: function(data)//Если запрос удачен
                        {
                            if (data == 'ok') { // Если все нормально
                                $('#username').removeClass('incorrect_field');
                                $('#username').css({'border': '1px solid #569b44'});
                                $('#username').next('.error-box').text('Принято')
                                    .css('color', 'green')
                                    .animate({'paddingLeft': '10px'}, 400)
                                    .animate({'paddingLeft': '5px'}, 400);
                            } else {
                                if (data == 'error') {
                                    $('#username').addClass('incorrect_field');
                                    $('#username').css({'border': '1px solid #ff0000'});
                                    $('#username').next('.error-box').html('Пользователь с таким логином уже существует!<br>')
                                        .css('color', 'red')
                                        .animate({'paddingLeft': '10px'}, 400)
                                        .animate({'paddingLeft': '5px'}, 400);
                                }
                            }
                        },
                        error: function(e)
                        {
                            $('#username').addClass('incorrect_field');
                            $('#username').css({'border': '1px solid #ff0000'});
                            $('#username').next('.error-box').html('Проверка совпадений логинов не удалась!<br>')
                                .css('color', 'red')
                                .animate({'paddingLeft': '10px'}, 400)
                                .animate({'paddingLeft': '5px'}, 400);
                        }
                    });
                    $(this).removeClass('incorrect_field');
                    $(this).css({'border': '1px solid #569b44'});
                    $(this).next('.error-box').text('Принято')
                        .css('color', 'green')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                } else {
                    $(this).addClass('incorrect_field');
                    $(this).css({'border': '1px solid #ff0000'});
                    $(this).next('.error-box').html('Поле с логином не заполнено или заполнено некорректно! Длина имени должна составлять не менее 2-х символов, поле должно содержать только латинские буквы и цифры!')
                        .css('color', 'red')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                }
                break;
            case 'password':
                if (val.length > 8 && val != '') {
                    $(this).removeClass('incorrect_field');
                    $(this).css({'border': '1px solid #569b44'});
                    $(this).next('.error-box').text('Принято')
                        .css('color', 'green')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                } else {
                    $(this).addClass('incorrect_field');
                    $(this).css({'border': '1px solid #ff0000'});
                    $(this).next('.error-box').html('Поле с паролем не заполнено или заполнено не корректно! Длина пароля должна быть больше 8-ми символов')
                        .css('color', 'red')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                }
                break;
            case 'country':
                if (val.length > 2 && val != '') {
                    $(this).removeClass('incorrect_field');
                    $(this).css({'border': '1px solid #569b44'});
                    $(this).next('.error-box').text('Принято')
                        .css('color', 'green')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                } else {
                    $(this).addClass('incorrect_field');
                    $(this).css({'border': '1px solid #ff0000'});
                    $(this).next('.error-box').html('Поле с страной не заполнено или заполнено не верно! Длина поля должна быть больше 2-х символов')
                        .css('color', 'red')
                        .animate({'paddingLeft': '10px'}, 400)
                        .animate({'paddingLeft': '5px'}, 400);
                }
                break;
        }
    });
});