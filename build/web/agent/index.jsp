<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Agent</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
     <body>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>${message}</h1><br>
        <a href="<c:url value="/agentController/agentInfo"/>">Agent Info</a><br>
        <a href="<c:url value="/agentController/register"/>">Register Members</a><br>
        <a href="<c:url value="/agentController/login"/>">Login</a>
    </body>
</html>
