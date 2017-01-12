<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список всех видеоуроков</title>
</head>
<body>
<h2>Список всех видеоуроков</h2>
<table>
<c:forEach var="currentVideoTutorial" items="${videoTutorialsJsp}">
    <tr>
    <c:forEach items="${usersJsp}" var="currentUser">
        <c:if test="${currentVideoTutorial.ownerId == currentUser.userId}">
            <td><c:out value="${currentUser.name}" /></td>
            <td><c:out value="${currentVideoTutorial.description}" /></td>
        </c:if>
    </c:forEach>
    </tr>
</c:forEach>
</table>
</body>
</html>
