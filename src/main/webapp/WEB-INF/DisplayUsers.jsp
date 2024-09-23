<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Users</title>
        <%@include file="Header.jsp" %>
        <link rel="stylesheet" href="css/Display.css"/>
    </head>
    <body>
        <table id="tdata">
            <tr>
                <th>Name</th>
                <th>Surname</th>
            </tr>
                       
            <c:forEach var="users" items="${userList}">
                <tr>
                    <td><c:out value="${users.fname}" /></td>
                    <td><c:out value="${users.lname}" /></td>
                    <td id="btns1">
                        <form action="ApplicationServlet" method="post">
                            <input type="hidden" name="id" value="<c:out value='${users.id}' />" />
                            <input type="submit" name="actions" value="More Info" class="btns"/>
                            <input type="submit" name="actions" value="Delete" class="btns"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
                       
    </body>
</html>
