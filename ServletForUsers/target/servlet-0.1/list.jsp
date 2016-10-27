<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nanoboot
  Date: 25.10.2016
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>Users and cars</h1>
    <c:forEach items="${requestScope.idCarsAndUsersJsp}" var="currentCarAndUser">
        <tr>
        <c:forEach items="${requestScope.usersJsp}" var="currentUser">
            <c:if test="${currentCarAndUser.idUser == currentUser.id}">
                <td><c:out value="${currentUser.id}" /></td>
                <td><c:out value="${currentUser.firstName}" /></td>
                <td><c:out value="${currentUser.lastName}" /></td>
                <td><c:out value="${currentUser.dateOfBirth}" /></td>
                <td><c:out value="${currentUser.city}" /></td>
            </c:if>
        </c:forEach>
            &#9;
        <c:forEach items="${requestScope.carsJsp}" var="currentCar">
            <c:if test="${currentCarAndUser.idCar == currentCar.id}">
                <td><c:out value="${currentCar.brand}" /></td>
                <td><c:out value="${currentCar.model}" /></td>
                <td><c:out value="${currentCar.mileage}" /></td>
                <td><c:out value="${currentCar.colour}" /></td>
            </c:if>
        </c:forEach>
        </tr>
        <br>
    </c:forEach>
    <form>
        <input type="button" value="Add car" onclick="window.location='/addCar'">
    </form>
</body>
</html>
