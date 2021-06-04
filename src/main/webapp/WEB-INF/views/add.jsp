<%--
  Created by IntelliJ IDEA.
  User: pazur
  Date: 05.06.2021
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>

<form:form method="post"
           modelAttribute="customer">
    <form:input path="pesel"/>
    <form:errors path="pesel"/><br/>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <form:input path="surname"/>
    <form:errors path="surname"/><br/>
    <form:input path="city"/>
    <form:errors path="city"/><br/>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/><br/>
    <form:input path="information"/>
    <form:errors path="information"/><br/>
    <form:input path="offer"/>
    <form:errors path="offer"/><br/>

    <input type="submit" value="Save">
</form:form>

</body>
</html>

