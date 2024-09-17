<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New User</title>
        <%@include file="Header.jsp" %>
        <style>
            body{
                background-color: tan;
                margin: 20px;
            }
            form{
                border: 2px solid black;
                padding: 10px;
                display: grid;
            }
        </style>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="https://code.jquery.com/ui/1.14.0/jquery-ui.js"></script>
        <script>
            $(function(){
              $("#birthday").datepicker({
                  showAnim : 'slideDown',
                  maxDate: -1
              });
            });
        </script>
    </head>
    <body>
        <form action="ApplicationServlet" method="post">
            <label>Name:<br><input type="text" id="fname" required></label><br>
            <label>Surname:<br><input type="text" id="lname" required></label><br>
            <label>Gender: <select id="gender" required><option value="m">M</option><option value="f">F</option></select></label><br>
            <label>Birthday:<br><input type="text" id="birthday" required></label><br>
            <label>Work Address:<br><input type="text" id="waddress"></label><br>
            <label>Home Address:<br><input type="text" id="haddress"></label><br>
            <input type="submit" value="Register"/>
        </form>
        
    </body>
</html>
