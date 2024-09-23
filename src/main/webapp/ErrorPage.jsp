<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h2>Sorry, something went wrong..</h2>
        Exception message: <%= exception.getMessage() %>
        <br>Please go back to the <a href="index.html">Homepage</a>
    </body>
</html>
