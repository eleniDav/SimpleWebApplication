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
              $("#birthdate").datepicker({
                  showAnim : 'slideDown',
                  maxDate: -1,
                  dateFormat: 'yy-mm-dd',
                  changeMonth: true,
                  changeYear: true,
                  yearRange: "1930:2024"
              });
            });
        </script>
    </head>
    <body>
        <form action="ApplicationServlet" method="post" id="info">
            <label>* Name:<br><input type="text" name="fname" required></label><br>
            <label>* Surname:<br><input type="text" name="lname" required></label><br>
            <label>* Gender: <select name="gender" required><option value="">-</option><option value="m">M</option><option value="f">F</option></select></label><br>
            <label>* Birthdate:<br><input type="text" name="birthdate" id="birthdate" required></label><br>
            <label>Work Address:<br><textarea cols="30" name="waddress"></textarea></label><br>
            <label>Home Address:<br><textarea cols="30" name="haddress"></textarea></label><br>
            <input type="submit" name="actions" value="Register" class="btns"/>
            <br>* - Mandatory Fields
        </form>
    </body>
</html>
