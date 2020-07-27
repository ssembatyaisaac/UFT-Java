<%-- 
    Document   : display
    Created on : Jun 29, 2020, 11:24:49 AM
    Author     : ducky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Testing</h1>
        <span>${message}</span>
        <p>${member.firstName} </p>
        <p>${member.lastName}</p>
        <p>${member.gender}</p>
        <p>${member.dateOfBirth}</p>
        <p>${member.telephone1}</p>
        <p>${member.telephone2}</p>
        <p>${member.emailAddress}</p>
    </body>
</html>
