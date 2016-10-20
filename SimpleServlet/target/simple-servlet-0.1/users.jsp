<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All owners</title>
</head>
<body>
<h1>
    <c:forEach items="${requestScope.allOwners}" var="currentOwner">
        <tr>
            <td><c:out value="${currentOwner.firstName}" /><td>
            <td><c:out value="${currentOwner.lastName}" /><td>
            <td><c:out value="${currentOwner.dateOfBirth}" /><td>
            <td><c:out value="${currentOwner.city}" /><td>
        </tr>
    </c:forEach>
</h1>
</body>
</html>