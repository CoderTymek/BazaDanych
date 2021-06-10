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
           modelAttribute="customer"
           cssClass="addForm">
    <div class="formInput">
        <label for="pesel">PESEL:</label>
        <form:input path="pesel"/>
        <form:errors path="pesel"/>
    </div>
    <div class="formInput">
        <label for="name">IMIĘ:</label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </div>
    <div class="formInput">
        <label for="surname">NAZWISKO:</label>
        <form:input path="surname"/>
        <form:errors path="surname"/>
    </div>
    <div class="formInput">
        <label for="phoneNumber">NUMER TELEFONU:</label>
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
    </div>
    <div class="formInput">
        <label for="information.id">INFORMACJA:</label>
        <form:select path="information.id" multiple="false" size="1">
            <form:options items="${informations}" itemValue="id" itemLabel="name"/>
        </form:select>
    </div>
    <div class="formInput">
        <label for="offer.numberOfOffer">OFERTA:</label>
        <form:select path="offer.numberOfOffer" multiple="false" size="1">
            <form:options items="${offers}" itemValue="numberOfOffer" itemLabel="detailsOffer"/>
        </form:select>
    </div>


    <input type="submit" value="Save">
</form:form>

</body>
</html>


