<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>pesel</th>
    <th>name</th>
    <th>surname</th>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.pesel}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.surname}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

