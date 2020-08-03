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
        <title>Agents</title>
    </head>
    <body>
        <h1>Register agents</h1>
        <span>${message}</span>
        <p>${agent.firstName} </p>
        <p>${agent.lastName}</p>
        <p>${agent.gender}</p>
        <p>${agent.dateOfBirth}</p>
        <p>${agent.telephone1}</p>
        <p>${agent.telephone2}</p>
        <p>${agent.emailAddress}</p>
    </body>
</html>
