<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <p>This the admin page</p>
        <a href="<c:url value='/adminController/register'/>">Register agents</a><br>
        <a href="<c:url value='districts/district.jsp'/>">Add Districts</a>
</body>
</html>