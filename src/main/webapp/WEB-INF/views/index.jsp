<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Of Customers</title>
</head>
<body>

<table border="1">
    <thead>
    <th>pesel</th>
    <th>name</th>
    <th>surname</th>
    <th>phoneNumber</th>
    <th>information</th>
    <th>Offer</th>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.pesel}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.surname}"/></td>
            <td><c:out value="${customer.phoneNumber}"/></td>
            <td><c:out value="${customer.information.name}"/></td>
            <td><c:out value="${customer.offer.detailsOffer}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

