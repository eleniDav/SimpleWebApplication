<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
        <link rel="stylesheet" href="css/Header.css"/>
    </head>
    <body>
        <div id="container">
            <form action="ApplicationServlet" method="post">
                <input type="submit" name="actions" value="Homepage" id="main" class="btns"/>
                <input type="submit" name="actions" value="Register New User" class="btns"/>
                <input type="submit" name="actions" value="Display Users" class="btns"/>
            </form>
        </div>
    </body>
</html>
