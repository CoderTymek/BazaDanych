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
    <title>New Customer</title>

    <style>
        .addForm {
            display: flex;
            flex-direction: column;

            margin: 50px auto;
            border: 1px solid #000;
            width: fit-content;
        }

        .formInput {
            display: flex;
            justify-content: space-between;
        }
    </style>
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
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/><br/>
    <form:select path="information.id" multiple="false" size="1">
        <form:options items="${informations}" itemValue="id" itemLabel="name"/>
    </form:select><br/>
    <form:select path="offer.numberOfOffer" multiple="false" size="1">
        <form:options items="${offers}" itemValue="numberOfOffer" itemLabel="detailsOffer"/>
    </form:select><br/>
<%--    <form:input path="offer.numberOfOffer"/>--%>
<%--    <form:errors path="offer.numberOfOffer"/><br/>--%>
<%--    <form:input path="offer.detailsOffer"/>--%>
<%--    <form:errors path="offer.detailsOffer"/><br/>--%>


    <input type="submit" value="Save">
</form:form>

</body>
</html>

