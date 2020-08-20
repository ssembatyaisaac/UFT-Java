<%-- 
    Document   : login
    Created on : Aug 12, 2020, 9:02:03 AM
    Author     : ducky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Login</title>
    </head>
    <body>
        <table>
            <form action="agentController/login" method="post">
            <thead>Agent Login</thead>
            <tr>
                <td>Agent Email Address: </td>
                <td><input type="email" name="emailAddress" id=""></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="agentPassword" id=""></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"></td>
            </tr>
        </form>
        </table>
        <span>${message}</span>
    </body>
</html>
