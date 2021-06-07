<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List Of Customers</title>
</head>
<body>
<c:if test="${not empty notification}">
    <p>${notification}</p>
</c:if>
<table border="1">
    <thead>
    <th>pesel</th>
    <th>name</th>
    <th>surname</th>
    <th>phoneNumber</th>
    <th>information</th>
    <th>Offer</th>
    <th>Akcja</th>
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
            <td>
                <form:form method="post" action="/admin/customers/delete/${customer.pesel}">
                    <input type="submit" value="Usuń"/>
                </form:form>
                <form:form method="get" action="/admin/customers/edit/${customer.pesel}">
                    <input type="submit" value="Edytuj"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

