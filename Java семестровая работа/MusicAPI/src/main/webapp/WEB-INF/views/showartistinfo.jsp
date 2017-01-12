<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список музыкальных исполнителей</title>
</head>
<body>
<h2>Информация о списке загруженных исполнителей</h2>
<table border="0">
    <tr>
        <th>Изображение</th>
        <th>Имя</th>
        <th>Слушателей</th>
        <th>Прослушиваний</th>
    </tr>
    <c:forEach items="${allfavoriteartistinfojsp}" var="currentArtist">
        <tr>
            <td><img src="${currentArtist.image}" alt="Картинка не найдена"></td>
            <td><c:out value="${currentArtist.name}"/></td>
            <td><c:out value="${currentArtist.listeners}"/></td>
            <td><c:out value="${currentArtist.playcount}"/></td>
        </tr>
</c:forEach>
</table>
</body>
</html>
