<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New User</title>
        <%@include file="Header.jsp" %>
        <link rel="stylesheet" href="css/Register.css"/>
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
        <form action="ApplicationServlet" method="post" id="info">
            <label>Name:<br><input type="text" id="fname" required></label><br>
            <label>Surname:<br><input type="text" id="lname" required></label><br>
            <label>Gender: <select id="gender" required><option value="">-</option><option value="m">M</option><option value="f">F</option></select></label><br>
            <label>Birthday:<br><input type="text" id="birthday" required></label><br>
            <label>Work Address:<br><textarea cols="30" id="waddress"></textarea></label><br>
            <label>Home Address:<br><textarea cols="30" id="haddress"></textarea></label><br>
            <input type="submit" name="actions" value="Register" class="btns"/>
        </form>
    </body>
</html>
