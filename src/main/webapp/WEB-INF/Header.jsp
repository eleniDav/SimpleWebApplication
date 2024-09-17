<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <div style="border: thin solid saddlebrown; padding: 5px; background-color: black">
            <form action="ApplicationServlet" method="post">
                <input type="submit" name="action" value="Homepage"/>
                <input type="submit" name="action" value="Display Users"/>
                <input type="submit" name="action" value="Register User"/>
            </form>
        </div>
    </body>
</html>
