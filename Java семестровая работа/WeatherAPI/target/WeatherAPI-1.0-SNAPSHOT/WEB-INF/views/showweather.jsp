<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Получить погоду по городу</title>
</head>
<body>
<h2>Выбор города</h2>
<form name="Form" method="post">
    <select name="city" id="city" >
        <option selected value="Kazan,RU">Казань</option>
        <option value="Moscow,RU">Москва</option>
    </select>
    <br>
    <input type="submit" value="Получить погоду по городу">
</form>
<h2>Погода в выбранном городе</h2>
<br>Sost:${weatherjsp.sost}
<br>Temp:${weatherjsp.temp}
<br>Pressure:${weatherjsp.pressure}
<br>Humidity:${weatherjsp.humidity}
</body>
</html>
