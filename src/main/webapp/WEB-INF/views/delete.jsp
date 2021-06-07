<%--
  Created by IntelliJ IDEA.
  User: pazur
  Date: 07.06.2021
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Customer List</title>
</head>
<body>
<table border="1">
  <thead>
  <th>name</th>
  <th>surname</th>
  <th>phoneNumber</th>
  <th>information</th>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${customer.name}"/></td>
    <td><c:out value="${customer.surname}"/></td>
    <td><c:out value="${customer.phoneNumber}"/></td>
    <td><c:out value="${customer.information}"/></td>
    <td>
    </td>
  </tr>

  </tbody>
</table>
</body>
</html>

