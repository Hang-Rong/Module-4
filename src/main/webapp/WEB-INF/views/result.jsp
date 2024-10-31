<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2024
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h1>Your Selected Condiments</h1>
<c:choose>
    <c:when test="${not empty selectedCondiments}">
        <ul>
            <c:forEach var="condiment" items="${selectedCondiments}">
                <li>${condiment}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No condiments selected.</p>
    </c:otherwise>
</c:choose>
<a href="/sandwich/">Back to Selection</a>
</body>
</html>
