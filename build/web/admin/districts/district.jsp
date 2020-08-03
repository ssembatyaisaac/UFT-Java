<%-- 
    Document   : district
    Created on : Jul 31, 2020, 12:50:54 PM
    Author     : ducky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Districts</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form action="<c:url value='/adminController/district'/>" method="post">
            <table>
                <p>Enter new district</p>
                <tr>
                    <td>District name</td>
                    <td><input type="text" name="districtName" id=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
