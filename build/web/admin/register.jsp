<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agent Registration</title>
</head>
<body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form action="<c:url value='/agentController/register'/>" method="post">
              <table>
                     <p>Member Registration</p>
                     <tr>
                            <td><label>First Name: </label></td>
                            <td><input type="text" name="fName" id="" required></td>
                     </tr>
                     <tr>
                            <td><label>Last Name: </label></td>
                            <td><input type="text" name="lName" id="" required></td>
                     </tr>
                     <tr>
                            <td><label>Gender: </label></td>
                            <td><input type="text" name="gender" id="" required></td>
                     </tr>
                     <tr>
                            <td><label>Date Of Birth: </label></td>
                            <td><input type="date" name="dateOfBirth" id="" required></td>
                     </tr>
                     <tr>
                            <td><label>Telephone 1: </label></td>
                            <td><input type="text" name="telephone1" id="" required></td>
                     </tr>
                     <tr>
                            <td><label>Telephone 2: </label></td>
                            <td><input type="text" name="telephone2" id=""></td>
                     </tr>
                     <tr>
                            <td><label>Email Address: </label></td>
                            <td><input type="email" name="emailAddress" id="" required></td>
                     </tr>
                     <tr>
                            <td></td>
                            <td><input type="submit" name="Register" id=""></td>
                     </tr>
              </table>
       </form>        
</body>
</html>