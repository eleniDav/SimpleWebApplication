<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
        <%@include file="Header.jsp" %>
    </head>
    <body style="background-color: cornsilk">
        <h2>User Info</h2>
        <b>First Name: </b><c:out value="${user.fname}" /> <br>
        <b>Last Name: </b><c:out value="${user.lname}" /> <br>
        <b>Gender: </b> 
            <c:if test = "${(user.gender).equals('F')}">
                <c:out value="Female" /> <br> 
            </c:if>
            <c:if test = "${(user.gender).equals('M')}">
                <c:out value="Male" /> <br> 
            </c:if>
        <b>Birthdate: </b><c:out value="${user.birthdate}" /> <br>
        <b>Work Address: </b>
            <c:if test = "${empty user.waddress}">
                <c:out value="-" /> <br> 
            </c:if>
            <c:if test = "${!empty user.waddress}">
                <c:out value="${user.waddress}" /> <br> 
            </c:if>
        <b>Home Address: </b>
            <c:if test = "${empty user.haddress}">
                <c:out value="-" /> <br> 
            </c:if>
            <c:if test = "${!empty user.haddress}">
                <c:out value="${user.haddress}" /> <br> 
            </c:if>
    </body>
</html>
