<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add owner</title>
</head>
<body>
    <h1>Список владельцев</h1>
    <p>
        <c:forEach items="${requestScope.allOwners}" var="currentUser">
            <tr>
                <td><c:out value="${currentUser}" /><td>
                <br>
            </tr>
        </c:forEach>
    </p>

    <h1>Добавление нового владельца</h1>
    <form action="users" method="post">
        First Name: <input type="text" name="firstName"> <br>
        Last Name: <input type="text" name="lastName"> <br>
        Date of birth <input type="date" name="dateOfBirth" value="1990-06-01"> <br>
        City: <input type="text" name="city"> <br>
        <input type="submit" value="Add new owner">
    </form>
</body>
</html>