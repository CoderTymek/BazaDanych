<%--
  Created by IntelliJ IDEA.
  User: pazur
  Date: 06.06.2021
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CustomerEdit</title>
</head>
<body>
<form:form method="post" modelAttribute="customer" action="/admin/customers/edit/${customer.pesel}">
    <form:input path="pesel"/>
    <form:errors path="pesel"/><br/>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <form:input path="surname"/>
    <form:errors path="surname"/><br/>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/><br/>
    <form:select path="information.id" multiple="false" size="1">
        <form:options items="${informations}" itemValue="id" itemLabel="name"/>
    </form:select><br/>
    <form:select path="offer.numberOfOffer" multiple="false" size="1">
        <form:options items="${offers}" itemValue="numberOfOffer" itemLabel="detailsOffer"/>
    </form:select><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


